package com.example.orderservice.Services;

import com.example.orderservice.DTOS.ItemDto;
import com.example.orderservice.DTOS.OrderRequestDto;
import com.example.orderservice.DTOS.UpdateOrderRequestDto;
import com.example.orderservice.Exceptions.OrderCreationException;
import com.example.orderservice.Exceptions.UserNotAuthenticated;
import com.example.orderservice.Models.OrderItem;
import com.example.orderservice.Models.PaymentStatus;
import com.example.orderservice.Repos.orderItemRepo;
import com.example.orderservice.Repos.orderRepo;
import com.example.orderservice.Models.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements orderService {
   private orderRepo orderRepo;
   private orderItemRepo orderItemRepo;

   public OrderServiceImpl(orderRepo orderRepo, orderItemRepo orderItemRepo) {
       this.orderRepo = orderRepo;
       this.orderItemRepo = orderItemRepo;
   }

    @Override
       public Order createOrder(OrderRequestDto orderRequestDto) throws OrderCreationException {
        try{
            Order newOrder = new Order();
            double amount = 0;
            newOrder.setCustomerId(orderRequestDto.getUserId());
            newOrder.setStatus(PaymentStatus.PENDING);

            Order savedOrder = orderRepo.save(newOrder);

            List<ItemDto> items = orderRequestDto.getItems();
            List<OrderItem> orderItems = new ArrayList<>();

            for (ItemDto item : items) {
                OrderItem orderItem = new OrderItem();
                orderItem.setProductId(item.getProductId());
                orderItem.setQuantity(item.getQuantity());
                orderItem.setPricePerPiece(item.getPrice());
                orderItem.setOrder(savedOrder);
                // Calculate the amount for each item
                amount += item.getQuantity() * item.getPrice();
                // Add the item to the orderItems list
                orderItems.add(orderItem);
            }
            savedOrder.setAmount(amount);
            orderItemRepo.saveAll(orderItems);
            return orderRepo.save(savedOrder);
        }catch(Exception e){
            throw new  OrderCreationException("An unexpected error occurred while creating the order",e);
        }
    }
@Override
    public Boolean updateOrder(UpdateOrderRequestDto updateOrderRequestDto){
       try {
           Long orderId = updateOrderRequestDto.getOrderId();
           String status = updateOrderRequestDto.getPaymentStatus();
           Order order = orderRepo.findById(orderId)
                   .orElseThrow(() -> new RuntimeException("Order not found"));

           order.setStatus(PaymentStatus.valueOf(status)); // "SUCCESS" or "FAILURE"
           orderRepo.save(order);
           return true;
       } catch (Exception e) {
           System.out.println("Error while updating payment status: " + e.getMessage());
           e.printStackTrace();
           return false;
       }
    };

}
