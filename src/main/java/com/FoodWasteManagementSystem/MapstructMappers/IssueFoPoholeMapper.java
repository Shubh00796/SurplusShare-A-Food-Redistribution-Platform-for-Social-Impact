package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.InventoryDto;
import com.FoodWasteManagementSystem.DTOs.IssueDTO;
import com.FoodWasteManagementSystem.DTOs.IssueUpdateDTO;
import com.FoodWasteManagementSystem.Domain.Inventory;
import com.FoodWasteManagementSystem.Domain.IssueForPothole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IssueFoPoholeMapper {
    IssueDTO toDto(IssueForPothole issueForPothole);

    IssueForPothole toEntity(IssueDTO issueDTO);

    @Mapping(target = "userId", ignore = true)
    void updateEntityFromDto(IssueUpdateDTO issueUpdateDTO, @MappingTarget IssueForPothole issueForPothole);

}
