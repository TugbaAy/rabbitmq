package com.tugbaay.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DirectExchangeProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirectExchangeProducerApplication.class, args);

        System.out.println("hello world - tugba is here");
    }

}
