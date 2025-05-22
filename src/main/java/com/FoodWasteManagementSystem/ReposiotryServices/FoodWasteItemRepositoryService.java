package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.FoodWasteItem;
import com.FoodWasteManagementSystem.Reposiotry.FoodWasteItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class FoodWasteItemRepositoryService {
    private final FoodWasteItemRepository repository;

    public List<FoodWasteItem> getAllFoodWasteItems() {
        return repository.findAll();
    }

    public FoodWasteItem getFoodWasteItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food waste item not found with id " + id));
    }

    public FoodWasteItem createFoodWasteItem(FoodWasteItem foodWasteItem) {
        Objects.requireNonNull(foodWasteItem);
        return repository.save(foodWasteItem);
    }

    public FoodWasteItem updateFoodWasteItem(FoodWasteItem foodWasteItem) {
        Objects.requireNonNull(foodWasteItem);
        return repository.save(foodWasteItem);
    }

    public void deleteFoodWasteItem(Long id) {
        repository.deleteById(id);
    }

    public List<FoodWasteItem> getFoodWasteItemsByFoodDonorId(Long foodDonorId) {
        return repository.findByFoodDonorId(foodDonorId);
    }
}