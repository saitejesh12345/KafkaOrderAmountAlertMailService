package com.example.OrderServiceAlertApp.repository;



import com.example.OrderServiceAlertApp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
