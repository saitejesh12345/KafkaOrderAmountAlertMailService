package com.example.OrderServiceAlertApp.alertmessage;


import com.example.OrderServiceAlertApp.kafkaproducer.OrderEventProducer;
import com.example.OrderServiceAlertApp.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Service
@Slf4j
public class AlertService {

    private double thresholdAmount=1000.00;


    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private OrderEventProducer orderEventProducer;

    public  void sendHighestOrderAlert(Order order) {
        if (order.getAmount() > thresholdAmount) {
            orderEventProducer.sendOrder(order);
            // Implement the logic to send an email alert
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("saitejeshwar56@gmail.com");
            message.setSubject("Highest Order Alert");
            message.setText("The order with ID " + order.getId() + " has exceeded the threshold amount.");
            try {
                javaMailSender.send(message);
                log.info("Email alert sent successfully for order ID: {}", order.getId());
            } catch (Exception e) {
                log.error("Failed to send email alert for order ID: {}. Error: {}", order.getId(), e.getMessage());
            }
        }
    }
}
