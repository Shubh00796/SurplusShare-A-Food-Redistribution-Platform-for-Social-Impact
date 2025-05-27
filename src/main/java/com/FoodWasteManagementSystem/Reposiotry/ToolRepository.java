package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.ToolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToolRepository extends JpaRepository<ToolEntity, Long> {
    Optional<ToolEntity> findByName(String name);
}
