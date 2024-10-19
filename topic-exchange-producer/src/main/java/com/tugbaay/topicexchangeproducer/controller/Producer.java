package com.tugbaay.topicexchangeproducer.controller;

import com.tugbaay.topicexchangeproducer.model.DataFromProducer;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.tugbaay.topicexchangeproducer.constant.TopicExchangeConstant.ROUTING_A;

@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange topicExchange;

    @PostMapping("/send")
    public String sendForA(@RequestBody DataFromProducer message) {
        rabbitTemplate.convertAndSend(topicExchange.getName(), ROUTING_A, message);
        return "Message is sent successfully to RabbitMq : " + message.toString();
    }

}
