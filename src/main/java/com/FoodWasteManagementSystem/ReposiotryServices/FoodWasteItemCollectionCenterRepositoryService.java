package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.FoodWasteItemCollectionCenter;
import com.FoodWasteManagementSystem.Reposiotry.FoodWasteItemCollectionCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class FoodWasteItemCollectionCenterRepositoryService {
    private final FoodWasteItemCollectionCenterRepository repository;

    public List<FoodWasteItemCollectionCenter> getAllFoodWasteItemCollectionCenters() {
        return repository.findAll();
    }

    public FoodWasteItemCollectionCenter getFoodWasteItemCollectionCenterById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food waste item collection center not found with id " + id));
    }

    public FoodWasteItemCollectionCenter createFoodWasteItemCollectionCenter(FoodWasteItemCollectionCenter foodWasteItemCollectionCenter) {
        Objects.requireNonNull(foodWasteItemCollectionCenter, "foodWasteItemCollectionCenter must not be null");
        return repository.save(foodWasteItemCollectionCenter);
    }

    public FoodWasteItemCollectionCenter updateFoodWasteItemCollectionCenter(FoodWasteItemCollectionCenter foodWasteItemCollectionCenter) {
        Objects.requireNonNull(foodWasteItemCollectionCenter);
        return repository.save(foodWasteItemCollectionCenter);
    }

    public void deleteFoodWasteItemCollectionCenter(Long id) {
        repository.deleteById(id);
    }

    public List<FoodWasteItemCollectionCenter> getFoodWasteItemCollectionCentersByFoodWasteItemId(Long foodWasteItemId) {
        return repository.findByFoodWasteItemId(foodWasteItemId);
    }

    public List<FoodWasteItemCollectionCenter> getFoodWasteItemCollectionCentersByCollectionCenterId(Long collectionCenterId) {
        return repository.findByCollectionCenterId(collectionCenterId);
    }
}