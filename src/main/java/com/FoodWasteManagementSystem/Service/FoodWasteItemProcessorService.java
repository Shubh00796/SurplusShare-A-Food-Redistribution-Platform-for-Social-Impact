package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.FoodWasteItemProcessorDto;

import java.util.List;

public interface FoodWasteItemProcessorService {
    List<FoodWasteItemProcessorDto> getAllFoodWasteItemProcessors();

    FoodWasteItemProcessorDto getFoodWasteItemProcessorById(Long id);

    FoodWasteItemProcessorDto createFoodWasteItemProcessor(FoodWasteItemProcessorDto foodWasteItemProcessorDto);

    FoodWasteItemProcessorDto updateFoodWasteItemProcessor(FoodWasteItemProcessorDto foodWasteItemProcessorDto);

    void deleteFoodWasteItemProcessor(Long id);

    List<FoodWasteItemProcessorDto> getFoodWasteItemProcessorsByFoodWasteItemId(Long foodWasteItemId);

    List<FoodWasteItemProcessorDto> getFoodWasteItemProcessorsByProcessorId(Long processorId);
}