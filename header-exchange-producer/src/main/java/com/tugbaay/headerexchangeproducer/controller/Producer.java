package com.tugbaay.headerexchangeproducer.controller;

import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tugbaay.headerexchangeproducer.constant.HeadersExchangeConstants.COLOR;
import static com.tugbaay.headerexchangeproducer.constant.HeadersExchangeConstants.EMPTY;

@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private HeadersExchange headersExchange;

    @PostMapping("/send/{message}")
    public String send(@PathVariable(value = "message") String message) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader(COLOR, message);

        MessageConverter messageConverter = new SimpleMessageConverter();

        Message messageFirst = messageConverter.toMessage(message, messageProperties);

        rabbitTemplate.send(headersExchange.getName(), EMPTY, messageFirst);

        return "Message is sent successfully to RabbitMq: " + message;
    }
}
