package com.tugbaay.producer.controller;

import com.tugbaay.producer.model.DataFromProducer;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.tugbaay.producer.constant.DirectExchangeConstants.ROUTING_A;
import static com.tugbaay.producer.constant.DirectExchangeConstants.ROUTING_B;

@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @PostMapping("/sendToA")
    public String sendForA(@RequestBody DataFromProducer message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), ROUTING_A, message);
        return "Message is sent successfully to RabbitMq : " + message.toString();
    }

    @PostMapping("/sendToB")
    public String sendForB(@RequestBody DataFromProducer message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), ROUTING_B, message);
        return "Message is sent successfully to RabbitMq : " + message.toString();
    }

}
