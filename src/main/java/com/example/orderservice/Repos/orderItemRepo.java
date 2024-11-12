package com.example.orderservice.Repos;

import com.example.orderservice.Models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface orderItemRepo extends JpaRepository<OrderItem, Integer> {

}
