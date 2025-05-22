package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.CollectionCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CollectionCenterRepository extends JpaRepository<CollectionCenter, Long> {
    Optional<CollectionCenter> findByIdAndLocation(Long id, String location);

    List<CollectionCenter> findByLocationContaining(String location);
}