package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.OrderDto;
import com.FoodWasteManagementSystem.Domain.OrderForEcommerse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.core.annotation.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(OrderForEcommerse order);

    OrderForEcommerse toEntity(OrderDto orderDto);

    void updateEntityFromDto(OrderDto orderDto, @MappingTarget OrderForEcommerse order);

}