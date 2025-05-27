package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.StructureDto;

import java.util.List;

public interface StructureService {
    List<StructureDto> getAllStructures();

    StructureDto getStructureById(Long id);

    StructureDto createStructure(StructureDto structureEntity);

    StructureDto updateStructure(StructureDto structureEntity);

    void deleteStructure(Long id);

    StructureDto getStructureByToolId(Long toolId);

    StructureDto getStructureByMaterialId(Long materialId);
}