package com.example.orderservice.Services;

import com.example.orderservice.DTOS.ItemDto;
import com.example.orderservice.DTOS.OrderRequestDto;
import com.example.orderservice.DTOS.OrderResponseDto;
import com.example.orderservice.DTOS.UpdateOrderRequestDto;
import com.example.orderservice.Models.Order;

import java.util.List;

public interface orderService {
 public Order createOrder(OrderRequestDto orderRequestDto);
 public Boolean updateOrder(UpdateOrderRequestDto updateOrderRequestDto);
 }
