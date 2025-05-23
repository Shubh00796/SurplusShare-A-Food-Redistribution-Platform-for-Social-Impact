package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.Inventory;
import com.FoodWasteManagementSystem.Reposiotry.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class InventoryRepositoryService {
    private final InventoryRepository repository;

    public List<Inventory> getAllInventories() {
        return repository.findAll();
    }

    public Inventory getInventoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id " + id));
    }

    public Inventory createInventory(Inventory inventory) {
        Objects.requireNonNull(inventory);
        return repository.save(inventory);
    }

    public Inventory updateInventory(Inventory inventory) {
        Objects.requireNonNull(inventory);
        return repository.save(inventory);
    }

    public void deleteInventory(Long id) {
        repository.deleteById(id);
    }

    public List<Inventory> getInventoriesByProductId(Long productId) {
        return repository.findByProductId(productId);
    }

    public List<Inventory> getInventoriesBySkuCode(String skuCode) {
        return repository.findBySkuCode(skuCode);
    }

    public List<Inventory> getInventoriesByDueDateBetween(LocalDate startDate, LocalDate endDate) {
        return repository.findByDueDateBetween(startDate, endDate);
    }
}
