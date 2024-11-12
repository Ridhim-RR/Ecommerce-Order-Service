package com.example.orderservice.Models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity(name = "orders")
@Data
public class Order extends BaseModel{
    private int customerId;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;
    private double amount;
//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    @OneToMany
//    private List<OrderItem> orderItems;

}
