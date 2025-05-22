package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.FoodWasteItemProcessor;
import com.FoodWasteManagementSystem.Reposiotry.FoodWasteItemProcessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class FoodWasteItemProcessorRepositoryService {
    private final FoodWasteItemProcessorRepository repository;

    public List<FoodWasteItemProcessor> getAllFoodWasteItemProcessors() {
        return repository.findAll();
    }

    public FoodWasteItemProcessor getFoodWasteItemProcessorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food waste item processor not found with id " + id));
    }

    public FoodWasteItemProcessor createFoodWasteItemProcessor(FoodWasteItemProcessor foodWasteItemProcessor) {
        Objects.requireNonNull(foodWasteItemProcessor, "foodWasteItemProcessor can not be null");
        return repository.save(foodWasteItemProcessor);
    }

    public FoodWasteItemProcessor updateFoodWasteItemProcessor(FoodWasteItemProcessor foodWasteItemProcessor) {
        Objects.requireNonNull(foodWasteItemProcessor, "foodWasteItemProcessor can not be null");
        return repository.save(foodWasteItemProcessor);
    }

    public void deleteFoodWasteItemProcessor(Long id) {
        repository.deleteById(id);
    }

    public List<FoodWasteItemProcessor> getFoodWasteItemProcessorsByFoodWasteItemId(Long foodWasteItemId) {
        return repository.findByFoodWasteItemId(foodWasteItemId);
    }

    public List<FoodWasteItemProcessor> getFoodWasteItemProcessorsByProcessorId(Long processorId) {
        return repository.findByProcessorId(processorId);
    }
}