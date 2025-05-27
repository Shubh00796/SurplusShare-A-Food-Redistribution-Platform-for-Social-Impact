package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.ToolEntity;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.Reposiotry.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class ToolRepositoryService {
    private final ToolRepository repository;

    public List<ToolEntity> getAllTools() {
        return repository.findAll();
    }

    public ToolEntity getToolById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tool not found with id " + id));
    }

    public ToolEntity createTool(ToolEntity toolEntity) {
        Objects.requireNonNull(toolEntity);
        return repository.save(toolEntity);
    }

    public ToolEntity updateTool(ToolEntity toolEntity) {
        Objects.requireNonNull(toolEntity);
        return repository.save(toolEntity);
    }

    public ToolEntity getToolByname(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("name npy found" + name));
    }

    public void deleteTool(Long id) {
        repository.deleteById(id);
    }
}