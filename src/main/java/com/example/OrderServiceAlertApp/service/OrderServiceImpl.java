package com.example.OrderServiceAlertApp.service;


import com.example.OrderServiceAlertApp.alertmessage.AlertService;
import com.example.OrderServiceAlertApp.model.Order;
import com.example.OrderServiceAlertApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AlertService alertService;

    @Override
    public Order saveOrder(Order order) {
        alertService.sendHighestOrderAlert(order);
        return orderRepository.save(order);
    }




//    @Override
//    public List<Order> getAllOrders() {
//        // Implement the logic to get all orders
//        return orderRepository.findAll();
//    }
//
//    @Override
//    public Order getOrderById(Long id) {
//        // Implement the logic to get an order by id
//        return orderRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void updateOrder(Order order) {
//        // Implement the logic to update the order
//        orderRepository.save(order);
//    }
//
//    @Override
//    public void deleteOrder(Long id) {
//        // Implement the logic to delete the order
//        orderRepository.deleteById(id);
//    }
}
