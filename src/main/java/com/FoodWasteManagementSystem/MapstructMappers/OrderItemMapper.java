package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.OrderItemDto;
import com.FoodWasteManagementSystem.Domain.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemDto toDto(OrderItem orderItem);

    OrderItem toEntity(OrderItemDto orderItemDto);

    void updateEntityFromDto(OrderItemDto orderItemDto, @MappingTarget OrderItem orderItem);

}