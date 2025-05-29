package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.OrderDTOForInventory;
import com.FoodWasteManagementSystem.Domain.OrderForInventory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderForInventoryMapper {
    OrderDTOForInventory toDto(OrderForInventory order);

    OrderForInventory toEntity(OrderDTOForInventory orderDTO);

    void updateEntityFromDto(OrderDTOForInventory orderDTO, @MappingTarget OrderForInventory order);
}