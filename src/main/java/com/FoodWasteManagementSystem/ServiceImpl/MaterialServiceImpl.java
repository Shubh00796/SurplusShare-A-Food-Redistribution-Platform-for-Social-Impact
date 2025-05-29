package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.MaterialDto;
import com.FoodWasteManagementSystem.Domain.MaterialEntity;
import com.FoodWasteManagementSystem.MapstructMappers.MaterialMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.MaterialRepositoryService;
import com.FoodWasteManagementSystem.Service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepositoryService repositoryService;
    private final MaterialMapper mapper;

    @Override
    public List<MaterialDto> getAllMaterials() {
        return repositoryService.getAllMaterials()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public MaterialDto getMaterialById(Long id) {
        MaterialEntity repositoryServiceMaterialById = repositoryService.getMaterialById(id);
        return mapper.toDto(repositoryServiceMaterialById);
    }

    @Override
    public MaterialDto getMaterialByName(String name) {
        Objects.requireNonNull(name, "name can not be null");
        String lowerCase = name.trim().toLowerCase();
        MaterialEntity materialByName = repositoryService.getMaterialByName(lowerCase);
        return mapper.toDto(materialByName);
    }

    @Override
    public MaterialDto createMaterial(MaterialDto materialDto) {
        validateIfNotNull(materialDto);

        validateIfGreaterThenZero(materialDto);
        MaterialEntity materialEntity = mapper.toEntity(materialDto);


        return mapper.toDto(repositoryService.createMaterial(materialEntity));
    }

    private static void validateIfGreaterThenZero(MaterialDto materialDto) {
        if (materialDto.getWeight().compareTo(BigDecimal.ZERO) <= 0 && materialDto.getQuantity().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("BOTH MUST BE GREATER THAN 0");
        }
    }

    private static void validateIfNotNull(MaterialDto materialDto) {
        Objects.requireNonNull(materialDto, "materialDto can not be null");
        Objects.requireNonNull(materialDto.getName(), "name can not be null");
        Objects.requireNonNull(materialDto.getWeight(), "Weight can not be null");
        Objects.requireNonNull(materialDto.getQuantity(), "Quantity can not be null");
    }

    @Override
    public MaterialDto updateMaterial(MaterialDto materialDto) {
        MaterialEntity repositoryServiceMaterialById = validateMaterialId(materialDto);
        validateIfGreaterThenZero(materialDto);
        mapper.updateEntityFromDto(materialDto, repositoryServiceMaterialById);

        return mapper.toDto(repositoryService.updateMaterial(repositoryServiceMaterialById));
    }

    private MaterialEntity validateMaterialId(MaterialDto materialDto) {
        MaterialEntity repositoryServiceMaterialById = repositoryService.getMaterialById(materialDto.getId());
        if (repositoryServiceMaterialById == null) {
            throw new IllegalArgumentException("Id can not be Null");
        }
        return repositoryServiceMaterialById;
    }

    @Override
    public void deleteMaterial(Long id) {
        repositoryService.deleteMaterial(id);

    }
}
