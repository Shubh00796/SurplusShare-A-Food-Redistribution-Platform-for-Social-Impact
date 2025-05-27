package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.StructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StructureRepository extends JpaRepository<StructureEntity, Long> {

    StructureEntity findByToolId(Long toolId);

    StructureEntity findByMaterialId(Long materialId);
}