package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.FoodWasteItemCollectionCenterDto;

import java.util.List;

public interface FoodWasteItemCollectionCenterService {
    List<FoodWasteItemCollectionCenterDto> getAllFoodWasteItemCollectionCenters();
    FoodWasteItemCollectionCenterDto getFoodWasteItemCollectionCenterById(Long id);
    FoodWasteItemCollectionCenterDto createFoodWasteItemCollectionCenter(FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto);
    FoodWasteItemCollectionCenterDto updateFoodWasteItemCollectionCenter(FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto);
    void deleteFoodWasteItemCollectionCenter(Long id);
    List<FoodWasteItemCollectionCenterDto> getFoodWasteItemCollectionCentersByFoodWasteItemId(Long foodWasteItemId);
    List<FoodWasteItemCollectionCenterDto> getFoodWasteItemCollectionCentersByCollectionCenterId(Long collectionCenterId);
}