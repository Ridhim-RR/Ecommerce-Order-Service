package com.example.orderservice.DTOS;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class ItemDto {
   private int productId;
   private int  quantity;
   private double  price;
}
