package com.FoodWasteManagementSystem.DTOs;

import lombok.Data;

@Data
public class CollectionCenterDto {
    private Long id;
    private String location;
    private Double maxCapacity;
}