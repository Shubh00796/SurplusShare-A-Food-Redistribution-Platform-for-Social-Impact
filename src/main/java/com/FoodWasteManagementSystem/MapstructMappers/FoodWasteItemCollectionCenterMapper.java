package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.CollectionCenterDto;
import com.FoodWasteManagementSystem.DTOs.FoodWasteItemCollectionCenterDto;
import com.FoodWasteManagementSystem.Domain.CollectionCenter;
import com.FoodWasteManagementSystem.Domain.FoodWasteItemCollectionCenter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FoodWasteItemCollectionCenterMapper {
    FoodWasteItemCollectionCenterDto toDto(FoodWasteItemCollectionCenter foodWasteItemCollectionCenter);

    FoodWasteItemCollectionCenter toEntity(FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto);

    void updateEntityFromDto(FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto, @MappingTarget FoodWasteItemCollectionCenter foodWasteItemCollectionCenter);

}