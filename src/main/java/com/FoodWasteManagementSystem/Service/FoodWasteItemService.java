package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.FoodWasteItemDto;

import java.util.List;

public interface FoodWasteItemService {

    List<FoodWasteItemDto> getAllFoodWasteItems();

    FoodWasteItemDto getFoodWasteItemById(Long id);

    FoodWasteItemDto createFoodWasteItem(FoodWasteItemDto foodWasteItemDto);

    FoodWasteItemDto updateFoodWasteItem(FoodWasteItemDto foodWasteItemDto);

    void deleteFoodWasteItem(Long id);

    List<FoodWasteItemDto> getFoodWasteItemsByFoodDonorId(Long foodDonorId);
}
