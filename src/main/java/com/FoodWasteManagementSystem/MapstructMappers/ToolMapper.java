package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.CollectionCenterDto;
import com.FoodWasteManagementSystem.DTOs.ToolDto;
import com.FoodWasteManagementSystem.Domain.CollectionCenter;
import com.FoodWasteManagementSystem.Domain.ToolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ToolMapper {
    ToolDto toDto(ToolEntity toolEntity);
    ToolEntity toEntity(ToolDto toolDto);
    void updateEntityFromDto(ToolDto toolDto, @MappingTarget ToolEntity toolEntity);

}