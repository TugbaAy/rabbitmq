package com.tugbaay.dirextexchangeconsumer.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
public class DataFromProducer {

    private String id;
    private String message;

}
