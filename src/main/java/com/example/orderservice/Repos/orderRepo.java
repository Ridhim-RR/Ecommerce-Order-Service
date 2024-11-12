package com.example.orderservice.Repos;

import com.example.orderservice.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepo extends JpaRepository<Order, Integer> {

}
