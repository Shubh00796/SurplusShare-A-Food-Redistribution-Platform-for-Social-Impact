package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.FoodWasteItemDto;
import com.FoodWasteManagementSystem.Service.FoodWasteItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food-waste-items")
public class FoodWasteItemController {
    private final FoodWasteItemService foodWasteItemService;

    @GetMapping
    public ResponseEntity<List<FoodWasteItemDto>> getAllFoodWasteItems() {
        List<FoodWasteItemDto> foodWasteItemDtos = foodWasteItemService.getAllFoodWasteItems();
        return new ResponseEntity<>(foodWasteItemDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodWasteItemDto> getFoodWasteItemById(@PathVariable Long id) {
        FoodWasteItemDto foodWasteItemDto = foodWasteItemService.getFoodWasteItemById(id);
        return new ResponseEntity<>(foodWasteItemDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FoodWasteItemDto> createFoodWasteItem(@RequestBody FoodWasteItemDto foodWasteItemDto) {
        FoodWasteItemDto createdFoodWasteItemDto = foodWasteItemService.createFoodWasteItem(foodWasteItemDto);
        return new ResponseEntity<>(createdFoodWasteItemDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodWasteItemDto> updateFoodWasteItem(@PathVariable Long id, @RequestBody FoodWasteItemDto foodWasteItemDto) {
        foodWasteItemDto.setId(id);
        FoodWasteItemDto updatedFoodWasteItemDto = foodWasteItemService.updateFoodWasteItem(foodWasteItemDto);
        return new ResponseEntity<>(updatedFoodWasteItemDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodWasteItem(@PathVariable Long id) {
        foodWasteItemService.deleteFoodWasteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/food-donor/{foodDonorId}")
    public ResponseEntity<List<FoodWasteItemDto>> getFoodWasteItemsByFoodDonorId(@PathVariable Long foodDonorId) {
        List<FoodWasteItemDto> foodWasteItemDtos = foodWasteItemService.getFoodWasteItemsByFoodDonorId(foodDonorId);
        return new ResponseEntity<>(foodWasteItemDtos, HttpStatus.OK);
    }
}