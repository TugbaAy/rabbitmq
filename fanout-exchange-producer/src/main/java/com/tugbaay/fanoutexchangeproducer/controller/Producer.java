package com.tugbaay.fanoutexchangeproducer.controller;

import com.tugbaay.fanoutexchangeproducer.model.DataFromProducer;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.tugbaay.fanoutexchangeproducer.constant.FanoutExchangeContants.EMPTY;

@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    @PostMapping("/send")
    public String send(@RequestBody DataFromProducer message) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), EMPTY, message);
        return "Message is sent successfully to RabbitMq : " + message.toString();
    }

}
