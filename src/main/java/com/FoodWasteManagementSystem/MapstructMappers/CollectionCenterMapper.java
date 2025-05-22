package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.CollectionCenterDto;
import com.FoodWasteManagementSystem.DTOs.FoodDonorDto;
import com.FoodWasteManagementSystem.Domain.CollectionCenter;
import com.FoodWasteManagementSystem.Domain.FoodDonor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CollectionCenterMapper {
    CollectionCenterDto toDto(CollectionCenter collectionCenter);

    CollectionCenter toEntity(CollectionCenterDto collectionCenterDto);

    void updateEntityFromDto(CollectionCenterDto collectionCenterDto, @MappingTarget CollectionCenter collectionCenter);

}