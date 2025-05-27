package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.StructureEntity;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.Reposiotry.StructureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class StructureRepositoryService {
    private final StructureRepository repository;

    public List<StructureEntity> getAllStructures() {
        return repository.findAll();
    }

    public StructureEntity getStructureById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Structure not found with id " + id));
    }

    public StructureEntity createStructure(StructureEntity structureEntity) {
        Objects.requireNonNull(structureEntity);
        return repository.save(structureEntity);
    }

    public StructureEntity updateStructure(StructureEntity structureEntity) {
        Objects.requireNonNull(structureEntity);

        return repository.save(structureEntity);
    }

    public void deleteStructure(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Structure not found with id " + id);
        }
        repository.deleteById(id);
    }

    public StructureEntity getStructureByToolId(Long toolId) {
        return repository.findById(toolId)
                .orElseThrow(() -> new ResourceNotFoundException("Structure not found with id " + toolId));
    }

    public StructureEntity getStructureByMaterialId(Long materialId) {
        return repository.findById(materialId)
                .orElseThrow(() -> new ResourceNotFoundException("Structure not found with id " + materialId));
    }

}


