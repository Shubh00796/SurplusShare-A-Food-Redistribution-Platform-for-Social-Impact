package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.FoodDonorDto;
import com.FoodWasteManagementSystem.Domain.FoodDonor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodDonorMapper {
    FoodDonorDto toDto(FoodDonor foodDonor);

    FoodDonor toEntity(FoodDonorDto foodDonorDto);

    List<FoodDonorDto> toDtos(List<FoodDonor> foodDonors);

    List<FoodDonor> toEntities(List<FoodDonorDto> foodDonorDtos);

    void updateEntityFromDto(FoodDonorDto foodDonorDto, @MappingTarget FoodDonor foodDonor);

}