package com.example.orderservice.DTOS;

import lombok.Data;

import java.util.List;
@Data
public class OrderRequestDto {
    private int userId;
    private List<ItemDto> items;


}
