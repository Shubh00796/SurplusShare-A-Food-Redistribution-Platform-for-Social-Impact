package com.FoodWasteManagementSystem.DTOs;


import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
