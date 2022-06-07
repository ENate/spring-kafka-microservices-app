package com.minejava.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.minejava.orderservice.dto.InventoryResponse;
import com.minejava.orderservice.dto.OrderLineItemsDto;
import com.minejava.orderservice.dto.OrderRequest;
import com.minejava.orderservice.model.Order;
import com.minejava.orderservice.model.OrderLineItems;
import com.minejava.orderservice.repository.OrderRepository;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.Tracer.SpanInScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // auto create constructor for repo object
@Transactional // spring framework creates transaction auto
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final Tracer tracer;

    public String placeOrder(OrderRequest orderRequest) {
        // Create order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        // Map order line items to order-line items via request
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                    .stream()
                    .map(this::mapToDto)
                    .toList();
                    // constructed an object of type order: save order to data base
                    // create repo
        order.setOrderLineItemsList(orderLineItems);
        // Call inventory service and place order if product is in stock
        List<String> skuCodes = order.getOrderLineItemsList().stream()
                                .map(OrderLineItems::getSkuCode)
                                .toList();
        Span inventoryServiceLookup = tracer.nextSpan().name("inventoryServiceLookup");

        try (SpanInScope spanInScope = tracer.withSpan(inventoryServiceLookup.start())) {


        InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);
        if (allProductsInStock) {
            orderRepository.save(order);
            return "Order placed successfully!";
        }
        else {
            throw new IllegalArgumentException("Product currently not in stock");
        }

    } finally {
        inventoryServiceLookup.end();
    }
    }
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
