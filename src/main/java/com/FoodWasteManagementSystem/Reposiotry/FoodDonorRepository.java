package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.FoodDonor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodDonorRepository extends JpaRepository<FoodDonor, Long> {
    Optional<FoodDonor> findByName(String name);
    List<FoodDonor> findByAddressContaining(String address);
}