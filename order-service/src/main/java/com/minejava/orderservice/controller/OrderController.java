package com.minejava.orderservice.controller;

import com.minejava.orderservice.dto.OrderRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {
    
    // Define post mapping and request body to send via rest
    @PostMapping
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        return "Order returned successfully!";
    }
}
