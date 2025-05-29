package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.OrderDTOForInventory;
import com.FoodWasteManagementSystem.DTOs.OrderItemForInventoryDTO;
import com.FoodWasteManagementSystem.Domain.OrderItemForInventory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderItemForInventoryMapper {
    OrderItemForInventoryDTO toDto(OrderItemForInventory orderItem);

    OrderItemForInventory toEntity(OrderItemForInventoryDTO orderItemDTO);

    void updateEntityFromDto(OrderItemForInventoryDTO orderItemDTO, @MappingTarget OrderItemForInventory orderItem);
}