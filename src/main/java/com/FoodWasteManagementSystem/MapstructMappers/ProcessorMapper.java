package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.CollectionCenterDto;
import com.FoodWasteManagementSystem.DTOs.ProcessorDTO;
import com.FoodWasteManagementSystem.Domain.CollectionCenter;
import com.FoodWasteManagementSystem.Domain.Processor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProcessorMapper {
    ProcessorDTO toDto(Processor processor);

    Processor toEntity(ProcessorDTO processorDTO);

    void updateEntityFromDto(ProcessorDTO processorDTO, @MappingTarget Processor processor);

}