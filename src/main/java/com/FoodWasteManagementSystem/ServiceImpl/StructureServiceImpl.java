package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.StructureDto;
import com.FoodWasteManagementSystem.Domain.StructureEntity;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.StructureMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.StructureRepositoryService;
import com.FoodWasteManagementSystem.Service.MaterialService;
import com.FoodWasteManagementSystem.Service.StructureService;
import com.FoodWasteManagementSystem.Service.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StructureServiceImpl implements StructureService {
    private final StructureRepositoryService repositoryService;
    private final StructureMapper mapper;
    private final MaterialService materialService;
    private final ToolService toolService;

    @Override
    public List<StructureDto> getAllStructures() {
        return repositoryService.getAllStructures()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public StructureDto getStructureById(Long id) {
        Objects.requireNonNull(id, "Id CAN NOT BE NULL HERE");
        StructureEntity structureById = repositoryService.getStructureById(id);
        return mapper.toDto(structureById);
    }

    @Override
    public StructureDto createStructure(StructureDto structureEntity) {
        validateStructure(structureEntity);
        StructureEntity structureEntityToSave = mapper.toEntity(structureEntity);
        StructureEntity savedStructureEntity = repositoryService.createStructure(structureEntityToSave);
        return mapper.toDto(savedStructureEntity);

    }

    private void validateStructure(StructureDto structureEntity) {
        Optional.ofNullable(toolService.getToolById(structureEntity.getToolId()))
                .orElseThrow(() -> new ResourceNotFoundException("Tool not found with ID " + structureEntity.getToolId()));
        Optional.ofNullable(materialService.getMaterialById(structureEntity.getMaterialId()))
                .orElseThrow(() -> new ResourceNotFoundException("Material not found with ID " + structureEntity.getMaterialId()));

        Objects.requireNonNull(structureEntity, "IT CAN NOT BE NULL");
        Objects.requireNonNull(structureEntity.getName(), "Name CAN NOT BE NULL");
        Objects.requireNonNull(structureEntity.getMaterialId(), "Material CAN NOT BE NULL");
        Objects.requireNonNull(structureEntity.getToolId(), "Tool CAN NOT BE NULL");
    }

    @Override
    public StructureDto updateStructure(StructureDto structureEntity) {
        validateStructure(structureEntity);
        StructureEntity structureById = repositoryService.getStructureById(structureEntity.getId());
        Optional.ofNullable(structureById == null)
                .orElseThrow(() -> new ResourceNotFoundException("id can not be null"));
        mapper.updateEntityFromDto(structureEntity, structureById);

        return mapper.toDto(repositoryService.updateStructure(structureById));
    }

    @Override
    public void deleteStructure(Long id) {
        repositoryService.deleteStructure(id);

    }

    @Override
    public StructureDto getStructureByToolId(Long toolId) {
        StructureEntity structureByToolId = repositoryService.getStructureByToolId(toolId);
        return mapper.toDto(structureByToolId);
    }

    @Override
    public StructureDto getStructureByMaterialId(Long materialId) {
        StructureEntity structureByMaterialId = repositoryService.getStructureByMaterialId(materialId);
        return mapper.toDto(structureByMaterialId);
    }
}
