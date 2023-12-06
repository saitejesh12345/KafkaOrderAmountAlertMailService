# KafkaOrderAmountAlertMailService
Overall, this code represents an application that saves orders, sends order events to Kafka, consumes order events from Kafka, and sends email alerts for highest orders. It uses Spring Boot, Spring Data JPA, Kafka, and JavaMailSender for these functionalities.


This code appears to be a part of an application that handles orders and alerts based on the order amount. Let me explain the code in detail: 
1. **OrderController**: - This is a REST controller that handles incoming HTTP POST requests to create orders. - It uses the `OrderService` to save the order and then returns the saved order along with a status code.
2. **OrderService**: - This is an interface defining the contract for saving orders.
3. **OrderServiceImpl**: - This is the implementation of the `OrderService` interface. - It saves the order using the `OrderRepository` and sends a highest order alert using the `AlertService`.
4. **OrderRepository**: - This is a Spring Data repository interface for the `Order` entity.
5. **Order**: - This is an entity class representing an order with properties such as `id`, `productName`, and `amount`. - It is annotated with JPA annotations such as `@Entity`, `@Id`, `@GeneratedValue`, and `@Data` for automatic generation of getters, setters, and other boilerplate code.
6. **OrderEventProducer**: - This is a service responsible for sending order events to a Kafka topic named "HighestOrder" using a `KafkaTemplate`.
7. **OrderKafkaConsumer**: - This is a Kafka consumer that listens to the "HighestOrder" topic and consumes order events. - It uses the `AlertService` to check if the order amount is the highest and then logs the consumed message.
8. **AlertService**: - This service has a `thresholdAmount` property and is responsible for sending highest order alerts. - It uses the `JavaMailSender` to send email alerts and the `OrderEventProducer` to send order events to Kafka if the order amount exceeds the threshold.
9. **MailConfig**: - This class configures the `JavaMailSender` properties for sending email alerts.
10. **KafkaConsumerConfig**: - This class configures the Kafka consumer properties and deserializers for consuming order events from the "HighestOrder" topic.

     Installation
        ------------------------------------------------------------------------
            dependency:     Java 8
            download: https://kafka.apache.org/downloads  Scala - 2.13 (tgz)

            Extract it to drive:/kafka

            create folder drive:/kafka/data/zookeeper       //state maintanence
            create folder drive:/kafka/data/kafka           //kafka server logs

            open drive:/kafka/config/zookeeper.properties
            set the below prop:
                    dataDir=drive:/kafka/data/zookeeper

            open drive:/kafka/config/server.properties
            set the below prop:
                   log.dirs=drive:/kafka/data/kafka

            INSTALLATION IS DONE

        Start Up
        ------------------------------------------------------------------------

            Start ZooKeeper
                drive:\kafka\bin\windows>zookeeper-server-start.bat ../../config/zookeeper.properties

            Start Kafka
                drive:\kafka\bin\windows>kafka-server-start.bat ../../config/server.properties
**First Start Zookeeper server then start kafka Server after Running Both the Server then Start SpringBoot Application**

**Postman**

<img width="450" alt="image" src="https://github.com/saitejesh12345/KafkaOrderAmountAlertMailService/assets/108732167/b8172d55-373d-4ef2-ad10-718b05d3e7d9">

**Alertmail**

<img width="339" alt="image" src="https://github.com/saitejesh12345/KafkaOrderAmountAlertMailService/assets/108732167/d98ff4ce-bcbe-4d34-9c44-edfae7ed991b">

<img width="310" alt="image" src="https://github.com/saitejesh12345/KafkaOrderAmountAlertMailService/assets/108732167/27fb1dec-0112-4066-bfb2-b59762084b9e">

<img width="370" alt="image" src="https://github.com/saitejesh12345/KafkaOrderAmountAlertMailService/assets/108732167/8a323590-6d69-4951-a891-61cd4ad1245b">

<img width="313" alt="image" src="https://github.com/saitejesh12345/KafkaOrderAmountAlertMailService/assets/108732167/dfd75d49-7ac3-43c0-b6db-67c33822c38b">





