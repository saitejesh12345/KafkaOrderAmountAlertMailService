package com.example.OrderServiceAlertApp.kafkaconsumer;



import com.example.OrderServiceAlertApp.alertmessage.AlertService;
import com.example.OrderServiceAlertApp.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderKafkaConsumer {


    @Autowired
    private AlertService alertService;

    @KafkaListener(topics = "HighestOrder", groupId = "group_id")
    public void consumeOrder(Order order) {
        // Implement the logic to check if the order amount is the highest and send an email alert
       log.info("consumed message- {}",order);

    }
}
