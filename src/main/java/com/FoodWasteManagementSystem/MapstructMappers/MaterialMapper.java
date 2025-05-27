package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.MaterialDto;
import com.FoodWasteManagementSystem.DTOs.ToolDto;
import com.FoodWasteManagementSystem.Domain.MaterialEntity;
import com.FoodWasteManagementSystem.Domain.ToolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    MaterialDto toDto(MaterialEntity materialEntity);

    MaterialEntity toEntity(MaterialDto materialDto);

    void updateEntityFromDto(MaterialDto materialDto, @MappingTarget MaterialEntity materialEntity);

}