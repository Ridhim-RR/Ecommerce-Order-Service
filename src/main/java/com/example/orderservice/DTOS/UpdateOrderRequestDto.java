package com.example.orderservice.DTOS;

import com.example.orderservice.Models.PaymentStatus;
import lombok.Data;

@Data
public class UpdateOrderRequestDto {
    private Long orderId;
    private String paymentStatus;
}
