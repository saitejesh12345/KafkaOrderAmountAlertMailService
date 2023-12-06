package com.example.OrderServiceAlertApp.controller;


import com.example.OrderServiceAlertApp.model.Order;
import com.example.OrderServiceAlertApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.saveOrder(order);
        // Implement the logic to check if the order amount is the highest and send a Kafka message if it is
        return new ResponseEntity<>(savedOrder,HttpStatus.CREATED);
    }
}