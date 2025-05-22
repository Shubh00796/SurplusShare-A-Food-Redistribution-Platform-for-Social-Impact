package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.FoodDonorDto;

import java.util.List;

public interface FoodDonorService {
    List<FoodDonorDto> getAllFoodDonors();

    FoodDonorDto getFoodDonorById(Long id);

    FoodDonorDto createFoodDonor(FoodDonorDto foodDonorDto);

    FoodDonorDto updateFoodDonor(FoodDonorDto foodDonorDto);

    void deleteFoodDonor(Long id);
}