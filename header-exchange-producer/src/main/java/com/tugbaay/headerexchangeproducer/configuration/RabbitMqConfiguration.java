package com.tugbaay.headerexchangeproducer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.tugbaay.headerexchangeproducer.constant.HeadersExchangeConstants.*;

@Configuration
public class RabbitMqConfiguration {


    @Bean
    Queue queueA() {
        return new Queue(QUEUE_A, false);
    }

    @Bean
    Queue queueB() {
        return new Queue(QUEUE_B, false);
    }

    @Bean
    Queue queueAll() {
        return new Queue(QUEUE_ALL, false);
    }

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(HEADER_EXCHANGE_PRODUCER);
    }

    @Bean
    Binding bindingA(Queue queueA, HeadersExchange headersExchange) {
        return BindingBuilder.bind(queueA).to(headersExchange)
                .where(COLOR)
                .matches(RED);
    }

    @Bean
    Binding bindingB(Queue queueB, HeadersExchange headersExchange) {
        return BindingBuilder.bind(queueB).to(headersExchange)
                .where(COLOR)
                .matches(BLUE);
    }

    @Bean
    Binding bindingAll(Queue queueAll, HeadersExchange headersExchange) {
        return BindingBuilder.bind(queueAll).to(headersExchange)
                .where(COLOR)
                .matches(GREEN);
    }


    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
