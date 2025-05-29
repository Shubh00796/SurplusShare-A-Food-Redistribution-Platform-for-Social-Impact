package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.ProductsDTO;
import com.FoodWasteManagementSystem.Domain.Products;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductsMapper {
    ProductsDTO toDto(Products product);

    Products toEntity(ProductsDTO productDTO);

    void updateEntityFromDto(ProductsDTO productDTO, @MappingTarget Products product);
}