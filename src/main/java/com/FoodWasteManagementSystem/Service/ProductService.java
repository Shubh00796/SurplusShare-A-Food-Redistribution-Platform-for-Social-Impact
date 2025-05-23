package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto);

    void deleteProduct(Long id);

    List<ProductDto> getProductsByName(String name);
}