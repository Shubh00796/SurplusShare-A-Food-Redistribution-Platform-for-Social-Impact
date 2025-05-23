package com.FoodWasteManagementSystem.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDto {
    private Long id;
    private Long customerId;
    private LocalDate orderDate;
    private Double total;
}