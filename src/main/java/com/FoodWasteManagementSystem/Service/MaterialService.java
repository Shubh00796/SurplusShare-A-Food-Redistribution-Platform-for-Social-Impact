package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.MaterialDto;

import java.util.List;

public interface MaterialService {
    List<MaterialDto> getAllMaterials();

    MaterialDto getMaterialById(Long id);

    MaterialDto getMaterialByName(String name);

    MaterialDto createMaterial(MaterialDto materialDto);

    MaterialDto updateMaterial(MaterialDto materialDto);

    void deleteMaterial(Long id);
}