package com.FoodWasteManagementSystem.Controllers;


import com.FoodWasteManagementSystem.DTOs.FoodWasteItemProcessorDto;
import com.FoodWasteManagementSystem.Service.FoodWasteItemProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/food-waste-item-processors")
public class FoodWasteItemProcessorController {
    private final FoodWasteItemProcessorService foodWasteItemProcessorService;

    @GetMapping
    public ResponseEntity<List<FoodWasteItemProcessorDto>> getAllFoodWasteItemProcessors() {
        List<FoodWasteItemProcessorDto> foodWasteItemProcessorDtos = foodWasteItemProcessorService.getAllFoodWasteItemProcessors();
        return new ResponseEntity<>(foodWasteItemProcessorDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodWasteItemProcessorDto> getFoodWasteItemProcessorById(@PathVariable Long id) {
        FoodWasteItemProcessorDto foodWasteItemProcessorDto = foodWasteItemProcessorService.getFoodWasteItemProcessorById(id);
        return new ResponseEntity<>(foodWasteItemProcessorDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FoodWasteItemProcessorDto> createFoodWasteItemProcessor(@RequestBody FoodWasteItemProcessorDto foodWasteItemProcessorDto) {
        FoodWasteItemProcessorDto createdFoodWasteItemProcessorDto = foodWasteItemProcessorService.createFoodWasteItemProcessor(foodWasteItemProcessorDto);
        return new ResponseEntity<>(createdFoodWasteItemProcessorDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodWasteItemProcessorDto> updateFoodWasteItemProcessor(@PathVariable Long id, @RequestBody FoodWasteItemProcessorDto foodWasteItemProcessorDto) {
        foodWasteItemProcessorDto.setId(id);
        FoodWasteItemProcessorDto updatedFoodWasteItemProcessorDto = foodWasteItemProcessorService.updateFoodWasteItemProcessor(foodWasteItemProcessorDto);
        return new ResponseEntity<>(updatedFoodWasteItemProcessorDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodWasteItemProcessor(@PathVariable Long id) {
        foodWasteItemProcessorService.deleteFoodWasteItemProcessor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/food-waste-item/{foodWasteItemId}")
    public ResponseEntity<List<FoodWasteItemProcessorDto>> getFoodWasteItemProcessorsByFoodWasteItemId(@PathVariable Long foodWasteItemId) {
        List<FoodWasteItemProcessorDto> foodWasteItemProcessorDtos = foodWasteItemProcessorService.getFoodWasteItemProcessorsByFoodWasteItemId(foodWasteItemId);
        return new ResponseEntity<>(foodWasteItemProcessorDtos, HttpStatus.OK);
    }

    @GetMapping("/processor/{processorId}")
    public ResponseEntity<List<FoodWasteItemProcessorDto>> getFoodWasteItemProcessorsByProcessorId(@PathVariable Long processorId) {
        List<FoodWasteItemProcessorDto> foodWasteItemProcessorDtos = foodWasteItemProcessorService.getFoodWasteItemProcessorsByProcessorId(processorId);
        return new ResponseEntity<>(foodWasteItemProcessorDtos, HttpStatus.OK);
    }
}