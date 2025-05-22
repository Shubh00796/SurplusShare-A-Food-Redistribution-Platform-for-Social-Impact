package com.FoodWasteManagementSystem.DTOs;

import lombok.Data;

@Data
public class FoodWasteItemProcessorDto {
    private Long id;
    private Long foodWasteItemId;
    private Long processorId;
}