package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.InventoryDto;
import com.FoodWasteManagementSystem.Domain.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryDto toDto(Inventory inventory);

    Inventory toEntity(InventoryDto inventoryDto);

    void updateEntityFromDto(InventoryDto inventoryDto, @MappingTarget Inventory inventory);

}
