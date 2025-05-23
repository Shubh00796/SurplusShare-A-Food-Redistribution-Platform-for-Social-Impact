package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.InventoryDto;

import java.time.LocalDate;
import java.util.List;

public interface InventoryService {
    List<InventoryDto> getAllInventories();

    InventoryDto getInventoryById(Long id);

    InventoryDto createInventory(InventoryDto inventoryDto);

    InventoryDto updateInventory(InventoryDto inventoryDto);

    void deleteInventory(Long id);

    List<InventoryDto> getInventoriesByProductId(Long productId);

    List<InventoryDto> getInventoriesBySkuCode(String skuCode);

    List<InventoryDto> getInventoriesByDueDateBetween(LocalDate startDate, LocalDate endDate);
}