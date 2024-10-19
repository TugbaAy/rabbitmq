package com.tugbaay.topicexchangeconsumer.controller;

import com.tugbaay.topicexchangeconsumer.model.DataFromProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class Consumer {

    @RabbitListener(queues = "queue.A")
    public void listenToA(DataFromProducer dataFromProducer) {
        log.info("Received message from A : {}", dataFromProducer);
    }

    @RabbitListener(queues = "queue.B")
    public void listenToB(DataFromProducer dataFromProducer) {
        log.info("Received message from B : {}", dataFromProducer);
    }

    @RabbitListener(queues = "queue.all")
    public void listenToAll(DataFromProducer dataFromProducer) {
        log.info("Received message from ALL : {}", dataFromProducer);
    }


}
