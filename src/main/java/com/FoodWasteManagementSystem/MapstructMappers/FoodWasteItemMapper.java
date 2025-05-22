package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.FoodDonorDto;
import com.FoodWasteManagementSystem.DTOs.FoodWasteItemDto;
import com.FoodWasteManagementSystem.Domain.FoodDonor;
import com.FoodWasteManagementSystem.Domain.FoodWasteItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodWasteItemMapper {
    FoodWasteItemDto toDto(FoodWasteItem foodWasteItem);

    FoodWasteItem toEntity(FoodWasteItemDto foodWasteItemDto);


    void updateEntityFromDto(FoodWasteItemDto foodWasteItemDto, @MappingTarget FoodWasteItem foodWasteItem);

}