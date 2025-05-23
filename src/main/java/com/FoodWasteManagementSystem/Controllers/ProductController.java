package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.ProductDto;
import com.FoodWasteManagementSystem.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtos = productService.getAllProducts();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto createdProductDto = productService.createProduct(productDto);
        return new ResponseEntity<>(createdProductDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        productDto.setId(id);
        ProductDto updatedProductDto = productService.updateProduct(productDto);
        return new ResponseEntity<>(updatedProductDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProductDto>> getProductsByName(@PathVariable String name) {
        List<ProductDto> productDtos = productService.getProductsByName(name);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
}