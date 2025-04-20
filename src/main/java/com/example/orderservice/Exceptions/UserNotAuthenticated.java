package com.example.orderservice.Exceptions;

public class UserNotAuthenticated extends Exception {
    public UserNotAuthenticated(String msg){
        super(msg);
    }
}
