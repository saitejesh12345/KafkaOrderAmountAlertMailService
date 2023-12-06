package com.example.OrderServiceAlertApp.kafkaproducer;

import com.example.OrderServiceAlertApp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class OrderEventProducer {
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;
    public void sendOrder(Order order) {
        kafkaTemplate.send("HighestOrder", order);
    }
}
