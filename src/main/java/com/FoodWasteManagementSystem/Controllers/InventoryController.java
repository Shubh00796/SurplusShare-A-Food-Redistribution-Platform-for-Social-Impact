package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.InventoryDto;
import com.FoodWasteManagementSystem.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/inventories")
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAllInventories() {
        List<InventoryDto> inventoryDtos = inventoryService.getAllInventories();
        return new ResponseEntity<>(inventoryDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> getInventoryById(@PathVariable Long id) {
        InventoryDto inventoryDto = inventoryService.getInventoryById(id);
        return new ResponseEntity<>(inventoryDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventoryDto> createInventory(@RequestBody InventoryDto inventoryDto) {
        InventoryDto createdInventoryDto = inventoryService.createInventory(inventoryDto);
        return new ResponseEntity<>(createdInventoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryDto> updateInventory(@PathVariable Long id, @RequestBody InventoryDto inventoryDto) {
        inventoryDto.setId(id);
        InventoryDto updatedInventoryDto = inventoryService.updateInventory(inventoryDto);
        return new ResponseEntity<>(updatedInventoryDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<InventoryDto>> getInventoriesByProductId(@PathVariable Long productId) {
        List<InventoryDto> inventoryDtos = inventoryService.getInventoriesByProductId(productId);
        return new ResponseEntity<>(inventoryDtos, HttpStatus.OK);
    }

    @GetMapping("/sku-code/{skuCode}")
    public ResponseEntity<List<InventoryDto>> getInventoriesBySkuCode(@PathVariable String skuCode) {
        List<InventoryDto> inventoryDtos = inventoryService.getInventoriesBySkuCode(skuCode);
        return new ResponseEntity<>(inventoryDtos, HttpStatus.OK);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<InventoryDto>> getInventoriesByDueDateBetween(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        List<InventoryDto> inventoryDtos = inventoryService.getInventoriesByDueDateBetween(startDate, endDate);
        return new ResponseEntity<>(inventoryDtos, HttpStatus.OK);
    }
}