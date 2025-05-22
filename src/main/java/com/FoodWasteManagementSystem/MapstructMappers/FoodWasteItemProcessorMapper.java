package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.CollectionCenterDto;
import com.FoodWasteManagementSystem.DTOs.FoodWasteItemProcessorDto;
import com.FoodWasteManagementSystem.Domain.CollectionCenter;
import com.FoodWasteManagementSystem.Domain.FoodWasteItemProcessor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FoodWasteItemProcessorMapper {
    FoodWasteItemProcessorDto toDto(FoodWasteItemProcessor foodWasteItemProcessor);

    FoodWasteItemProcessor toEntity(FoodWasteItemProcessorDto foodWasteItemProcessorDto);

    void updateEntityFromDto(FoodWasteItemProcessorDto foodWasteItemProcessorDto, @MappingTarget FoodWasteItemProcessor foodWasteItemProcessor);

}