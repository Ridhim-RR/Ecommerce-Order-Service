package com.example.orderservice.Controllers;

import com.example.orderservice.Common.AuthCommon;
import com.example.orderservice.DTOS.OrderRequestDto;
import com.example.orderservice.DTOS.OrderResponseDto;
import com.example.orderservice.DTOS.UpdateOrderRequestDto;
import com.example.orderservice.DTOS.UserDto;
import com.example.orderservice.Exceptions.UserNotAuthenticated;
import com.example.orderservice.Models.Order;
import com.example.orderservice.Services.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.relational.core.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
private final orderService service;
private AuthCommon authCommon;
    @Value("${myapp.order.internalToken}")
    private String internalToken; // Add this field
@Autowired
  public OrderController(orderService service, AuthCommon authCommon) {
      this.service = service;
      this.authCommon = authCommon;
  }

  @PostMapping("/create")
    public ResponseEntity<OrderResponseDto> createNewOrder(@RequestBody OrderRequestDto orderRequestDto, @RequestHeader("Authorization") String auth ) throws UserNotAuthenticated {
        try {
            UserDto user = authCommon.validate(auth);
            if(user == null) {
                throw new UserNotAuthenticated("Token is not valid");
            }
            OrderResponseDto orderResponseDto = new OrderResponseDto();
             Order newOrder =  service.createOrder(orderRequestDto);
            orderResponseDto.setOrder_id(newOrder.getId());
            return new ResponseEntity(orderResponseDto, HttpStatus.OK);
        }catch (Exception e){
         return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
@PutMapping("/update")
    public ResponseEntity<String> updateOrder(@RequestBody UpdateOrderRequestDto updateOrderRequestDto, @RequestHeader("Authorization") String auth ) throws UserNotAuthenticated {
    try{
      if(!auth.equals("Bearer "+ internalToken)){
          throw new UserNotAuthenticated("Token is not valid");
      }
        boolean updated = service.updateOrder(updateOrderRequestDto);
        if(updated) {
            return ResponseEntity.ok("Order updated successfully!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order update failed!");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
    }

}

