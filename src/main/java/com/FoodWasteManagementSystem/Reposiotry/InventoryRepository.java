package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByProductIdAndSkuCode(Long productId, String skuCode);

    List<Inventory> findByProductId(Long productId);

    List<Inventory> findBySkuCode(String skuCode);

    List<Inventory> findByDueDateBetween(LocalDate startDate, LocalDate endDate);
}
