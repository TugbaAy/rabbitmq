package com.tugbaay.dirextexchangeconsumer.controller;

import com.tugbaay.dirextexchangeconsumer.model.DataFromProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "queue.A")
    private void receiveMessageFromA(DataFromProducer message) {
        log.info("Received message from queueA: " + message);
    }

    @RabbitListener(queues = "queue.B")
    private void receiveMessageFromB(DataFromProducer message) {
        log.info("Received message from queueB : " + message);
    }


}

