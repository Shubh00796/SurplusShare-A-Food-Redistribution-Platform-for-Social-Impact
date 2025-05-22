package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.FoodWasteItemCollectionCenterDto;
import com.FoodWasteManagementSystem.Service.FoodWasteItemCollectionCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/food-waste-item-collection-centers")
public class FoodWasteItemCollectionCenterController {
    private final FoodWasteItemCollectionCenterService foodWasteItemCollectionCenterService;

    @GetMapping
    public ResponseEntity<List<FoodWasteItemCollectionCenterDto>> getAllFoodWasteItemCollectionCenters() {
        List<FoodWasteItemCollectionCenterDto> foodWasteItemCollectionCenterDtos = foodWasteItemCollectionCenterService.getAllFoodWasteItemCollectionCenters();
        return new ResponseEntity<>(foodWasteItemCollectionCenterDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodWasteItemCollectionCenterDto> getFoodWasteItemCollectionCenterById(@PathVariable Long id) {
        FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto = foodWasteItemCollectionCenterService.getFoodWasteItemCollectionCenterById(id);
        return new ResponseEntity<>(foodWasteItemCollectionCenterDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FoodWasteItemCollectionCenterDto> createFoodWasteItemCollectionCenter(@RequestBody FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto) {
        FoodWasteItemCollectionCenterDto createdFoodWasteItemCollectionCenterDto = foodWasteItemCollectionCenterService.createFoodWasteItemCollectionCenter(foodWasteItemCollectionCenterDto);
        return new ResponseEntity<>(createdFoodWasteItemCollectionCenterDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodWasteItemCollectionCenterDto> updateFoodWasteItemCollectionCenter(@PathVariable Long id, @RequestBody FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto) {
        foodWasteItemCollectionCenterDto.setId(id);
        FoodWasteItemCollectionCenterDto updatedFoodWasteItemCollectionCenterDto = foodWasteItemCollectionCenterService.updateFoodWasteItemCollectionCenter(foodWasteItemCollectionCenterDto);
        return new ResponseEntity<>(updatedFoodWasteItemCollectionCenterDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodWasteItemCollectionCenter(@PathVariable Long id) {
        foodWasteItemCollectionCenterService.deleteFoodWasteItemCollectionCenter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/food-waste-item/{foodWasteItemId}")
    public ResponseEntity<List<FoodWasteItemCollectionCenterDto>> getFoodWasteItemCollectionCentersByFoodWasteItemId(@PathVariable Long foodWasteItemId) {
        List<FoodWasteItemCollectionCenterDto> foodWasteItemCollectionCenterDtos = foodWasteItemCollectionCenterService.getFoodWasteItemCollectionCentersByFoodWasteItemId(foodWasteItemId);
        return new ResponseEntity<>(foodWasteItemCollectionCenterDtos, HttpStatus.OK);
    }

    @GetMapping("/collection-center/{collectionCenterId}")
    public ResponseEntity<List<FoodWasteItemCollectionCenterDto>> getFoodWasteItemCollectionCentersByCollectionCenterId(@PathVariable Long collectionCenterId) {
        List<FoodWasteItemCollectionCenterDto> foodWasteItemCollectionCenterDtos = foodWasteItemCollectionCenterService.getFoodWasteItemCollectionCentersByCollectionCenterId(collectionCenterId);
        return new ResponseEntity<>(foodWasteItemCollectionCenterDtos, HttpStatus.OK);
    }
}