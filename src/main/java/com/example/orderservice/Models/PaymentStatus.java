package com.example.orderservice.Models;

import jakarta.persistence.Entity;

public enum PaymentStatus {
    PENDING,
    SUCCESS,
    FAILED
}
