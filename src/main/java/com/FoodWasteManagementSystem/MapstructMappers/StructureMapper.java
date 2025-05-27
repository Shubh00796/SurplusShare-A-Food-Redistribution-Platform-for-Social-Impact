package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.StructureDto;
import com.FoodWasteManagementSystem.Domain.StructureEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StructureMapper {
    StructureDto toDto(StructureEntity structureEntity);

    StructureEntity toEntity(StructureDto structureDto);

    void updateEntityFromDto(StructureDto structureDto, @MappingTarget StructureEntity structureEntity);

}