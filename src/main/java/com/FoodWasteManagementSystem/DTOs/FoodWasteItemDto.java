package com.FoodWasteManagementSystem.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FoodWasteItemDto {
    private Long id;
    private Double weight;
    private LocalDate expirationDate;
    private String type;
    private Long foodDonorId;
}