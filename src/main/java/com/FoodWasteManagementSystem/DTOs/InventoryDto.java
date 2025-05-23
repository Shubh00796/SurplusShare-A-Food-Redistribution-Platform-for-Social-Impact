package com.FoodWasteManagementSystem.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InventoryDto {
    private Long id;
    private Long productId;
    private String skuCode;
    private Integer quantity;
    private LocalDate dueDate;
    private LocalDate lastUpdatedDate;
    private String inventoryStatus;
}