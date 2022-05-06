package com.minejava.orderservice.service;

import java.util.List;
import java.util.UUID;

import com.minejava.orderservice.dto.OrderLineItemsDto;
import com.minejava.orderservice.dto.OrderRequest;
import com.minejava.orderservice.model.Order;
import com.minejava.orderservice.model.OrderLineItems;
import com.minejava.orderservice.repository.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // auto create constructor for repo object
@Transactional // spring framework creates transaction auto
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        // Create order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        // Map order line items to orderlime items via request
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                    .stream()
                    .map(this::mapToDto)
                    .toList();
                    // constructed an object of type order: save order to data base
                    // create repo
        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
    }
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
