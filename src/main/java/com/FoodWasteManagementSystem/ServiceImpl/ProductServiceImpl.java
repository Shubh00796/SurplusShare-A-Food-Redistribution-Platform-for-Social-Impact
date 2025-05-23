package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.ProductDto;
import com.FoodWasteManagementSystem.Domain.Product;
import com.FoodWasteManagementSystem.MapstructMappers.ProductMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.ProductRepositoryService;
import com.FoodWasteManagementSystem.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepositoryService repositoryService;
    private final ProductMapper mapper;

    @Override
    public List<ProductDto> getAllProducts() {
        return repositoryService.getAllProducts()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product productById = repositoryService.getProductById(id);
        return mapper.toDto(productById);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        validateProductDto(productDto);
        Product product = mapper.toEntity(productDto);

        return mapper.toDto(repositoryService.createProduct(product));
    }

    private static void validateProductDto(ProductDto productDto) {
        Objects.requireNonNull(productDto, "productDto can not be null");
        Objects.requireNonNull(productDto.getName(), "Product name cannot be null");
        Objects.requireNonNull(productDto.getDescription(), "Product description cannot be null");
        Objects.requireNonNull(productDto.getPrice(), "Product price cannot be null");
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        validateProductDto(productDto);
        Product existingproduct = repositoryService.getProductById(productDto.getId());
        mapper.updateEntityFromDto(productDto, existingproduct);


        return mapper.toDto(repositoryService.updateProduct(existingproduct));
    }

    @Override
    public void deleteProduct(Long id) {
        repositoryService.deleteProduct(id);

    }

    @Override
    public List<ProductDto> getProductsByName(String name) {
        return repositoryService.getProductsByName(name)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
