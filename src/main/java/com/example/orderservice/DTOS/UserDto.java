package com.example.orderservice.DTOS;

import com.example.orderservice.Models.Roles;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String name;
    private String email;
    private Boolean isVerified;
    private List<Roles> roles;

}
