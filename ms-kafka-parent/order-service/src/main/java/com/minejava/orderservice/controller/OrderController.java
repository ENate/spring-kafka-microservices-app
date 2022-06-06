package com.minejava.orderservice.controller;

import com.minejava.orderservice.dto.OrderRequest;
import com.minejava.orderservice.service.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    // create order service object to call order to controller
    private final OrderService orderService;
    // Define post mapping and request body to send via rest
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        // whenever the user places order, it will save and the info
        // returned will be displayed
        orderService.placeOrder(orderRequest);
        return "Order placed successfully!";
    }
}
