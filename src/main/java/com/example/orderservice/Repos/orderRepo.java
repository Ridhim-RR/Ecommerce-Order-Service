package com.example.orderservice.Repos;

import com.example.orderservice.Models.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface orderRepo extends JpaRepository<Order, Long> {

}
