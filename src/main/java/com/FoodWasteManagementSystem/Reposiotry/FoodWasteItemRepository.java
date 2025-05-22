package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.FoodWasteItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodWasteItemRepository extends JpaRepository<FoodWasteItem, Long> {
    Optional<FoodWasteItem> findByIdAndFoodDonorId(Long id, Long foodDonorId);

    List<FoodWasteItem> findByFoodDonorId(Long foodDonorId);
}