package com.tugbaay.headerexchangeconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class Consumer {

    @RabbitListener(queues = "queue.A")
    public void listenToA(String message) {
        log.info("Received message from A : {}", message);
    }

    @RabbitListener(queues = "queue.B")
    public void listenToB(String message) {
        log.info("Received message from B : {}", message);
    }

    @RabbitListener(queues = "queue.all")
    public void listenToAll(String message) {
        log.info("Received message from ALL : {}", message);
    }


}
