package com.FoodWasteManagementSystem.DTOs;

import lombok.Data;

@Data
public class FoodWasteItemCollectionCenterDto {
    private Long id;
    private Long foodWasteItemId;
    private Long collectionCenterId;
}