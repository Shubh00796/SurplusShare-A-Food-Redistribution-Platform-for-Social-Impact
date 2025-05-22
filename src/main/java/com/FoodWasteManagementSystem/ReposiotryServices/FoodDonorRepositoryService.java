package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.DTOs.FoodDonorDto;
import com.FoodWasteManagementSystem.Domain.FoodDonor;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.Reposiotry.FoodDonorRepository;
import com.FoodWasteManagementSystem.Service.FoodDonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodDonorRepositoryService {
    private final FoodDonorRepository repository;

    public List<FoodDonor> getAllFoodDonors() {
        return repository.findAll();
    }

    public FoodDonor getFoodDonorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id with given food donour not found" + id));
    }

    public FoodDonor createFoodDonor(FoodDonor foodDonor) {
        checkIfGoalIsNullOrNot(foodDonor);
        return repository.save(foodDonor);
    }

    public FoodDonor updateFoodDonor(FoodDonor foodDonor) {
        checkIfGoalIsNullOrNot(foodDonor);

        return repository.save(foodDonor);
    }

    public void deleteFoodDonor(Long id) {
        repository.deleteById(id);
    }

    private static void checkIfGoalIsNullOrNot(FoodDonor foodDonor) {
        if (foodDonor == null) {
            throw new IllegalArgumentException("Goal cannot be null");
        }
    }
}
