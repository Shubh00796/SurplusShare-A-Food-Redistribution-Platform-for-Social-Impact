package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.MaterialEntity;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.Reposiotry.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class MaterialRepositoryService {
    private final MaterialRepository repository;

    public List<MaterialEntity> getAllMaterials() {
        return repository.findAll();
    }

    public MaterialEntity getMaterialById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material not found with id " + id));
    }

    public MaterialEntity createMaterial(MaterialEntity materialEntity) {
        Objects.requireNonNull(materialEntity);
        return repository.save(materialEntity);
    }

    public MaterialEntity updateMaterial(MaterialEntity materialEntity) {
        Objects.requireNonNull(materialEntity);
        return repository.save(materialEntity);
    }

    public MaterialEntity getMaterialByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("name not found" + name));
    }

    public void deleteMaterial(Long id) {
        repository.deleteById(id);
    }
}