package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.FoodDonorDto;
import com.FoodWasteManagementSystem.Service.FoodDonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/food-donors")
public class FoodDonorController {
    private final FoodDonorService foodDonorService;

    @GetMapping
    public ResponseEntity<List<FoodDonorDto>> getAllFoodDonors() {
        List<FoodDonorDto> foodDonorDtos = foodDonorService.getAllFoodDonors();
        return new ResponseEntity<>(foodDonorDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDonorDto> getFoodDonorById(@PathVariable Long id) {
        FoodDonorDto foodDonorDto = foodDonorService.getFoodDonorById(id);
        return new ResponseEntity<>(foodDonorDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FoodDonorDto> createFoodDonor(@RequestBody FoodDonorDto foodDonorDto) {
        FoodDonorDto createdFoodDonorDto = foodDonorService.createFoodDonor(foodDonorDto);
        return new ResponseEntity<>(createdFoodDonorDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodDonorDto> updateFoodDonor(@PathVariable Long id, @RequestBody FoodDonorDto foodDonorDto) {
        foodDonorDto.setId(id);
        FoodDonorDto updatedFoodDonorDto = foodDonorService.updateFoodDonor(foodDonorDto);
        return new ResponseEntity<>(updatedFoodDonorDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodDonor(@PathVariable Long id) {
        foodDonorService.deleteFoodDonor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}