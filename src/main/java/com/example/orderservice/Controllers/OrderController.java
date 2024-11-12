package com.example.orderservice.Controllers;

import com.example.orderservice.DTOS.OrderRequestDto;
import com.example.orderservice.DTOS.OrderResponseDto;
import com.example.orderservice.Models.Order;
import com.example.orderservice.Services.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
private final orderService service;

@Autowired
  public OrderController(orderService service) {
      this.service = service;
  }
  @PostMapping("/create")
    public ResponseEntity<OrderResponseDto> createNewOrder(@RequestBody OrderRequestDto orderRequestDto) {
        try {
            System.out.println(orderRequestDto.getItems()+"jhhhhhii");
            OrderResponseDto orderResponseDto = new OrderResponseDto();
             Order newOrder =  service.createOrder(orderRequestDto);
            orderResponseDto.setOrder_id(newOrder.getId());
            return new ResponseEntity(orderResponseDto, HttpStatus.OK);
        }catch (Exception e){
         return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
