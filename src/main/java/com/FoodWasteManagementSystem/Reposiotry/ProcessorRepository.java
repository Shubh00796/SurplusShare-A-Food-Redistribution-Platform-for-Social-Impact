package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.Processor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProcessorRepository extends JpaRepository<Processor, Long> {
    Optional<Processor> findByNameAndLocation(String name, String location);

    List<Processor> findByNameContaining(String name);
}