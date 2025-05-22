package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.FoodWasteItemCollectionCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodWasteItemCollectionCenterRepository extends JpaRepository<FoodWasteItemCollectionCenter, Long> {
    Optional<FoodWasteItemCollectionCenter> findByFoodWasteItemIdAndCollectionCenterId(Long foodWasteItemId, Long collectionCenterId);

    List<FoodWasteItemCollectionCenter> findByFoodWasteItemId(Long foodWasteItemId);

    List<FoodWasteItemCollectionCenter> findByCollectionCenterId(Long collectionCenterId);
}