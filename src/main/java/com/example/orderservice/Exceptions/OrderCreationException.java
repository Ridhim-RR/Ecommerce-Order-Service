package com.example.orderservice.Exceptions;

public class OrderCreationException extends RuntimeException{
    public OrderCreationException(String message, Throwable cause) {
        super(message,cause);
    }
}
