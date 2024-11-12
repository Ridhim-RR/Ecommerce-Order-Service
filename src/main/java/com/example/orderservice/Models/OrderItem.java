package com.example.orderservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderItem extends BaseModel{
    private int productId;
    private int  quantity;
    private double  pricePerPiece;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
