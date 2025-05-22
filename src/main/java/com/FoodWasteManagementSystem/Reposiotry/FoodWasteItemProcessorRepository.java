package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.FoodWasteItemProcessor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodWasteItemProcessorRepository extends JpaRepository<FoodWasteItemProcessor, Long> {
    Optional<FoodWasteItemProcessor> findByFoodWasteItemIdAndProcessorId(Long foodWasteItemId, Long processorId);

    List<FoodWasteItemProcessor> findByFoodWasteItemId(Long foodWasteItemId);

    List<FoodWasteItemProcessor> findByProcessorId(Long processorId);
}