package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.ProductDto;
import com.FoodWasteManagementSystem.Domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);

    void updateEntityFromDto(ProductDto productDto, @MappingTarget Product product);
}