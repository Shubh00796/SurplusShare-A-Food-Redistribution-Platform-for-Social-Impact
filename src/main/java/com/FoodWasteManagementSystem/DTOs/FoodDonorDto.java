package com.FoodWasteManagementSystem.DTOs;

import lombok.Data;

@Data
public class FoodDonorDto {
    private Long id;
    private String name;
    private String address;
    private String contactInformation;
}