package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.Product;
import com.FoodWasteManagementSystem.Reposiotry.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class ProductRepositoryService {
    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    public Product createProduct(Product product) {
        Objects.requireNonNull(product);
        return repository.save(product);
    }

    public Product updateProduct(Product product) {
        Objects.requireNonNull(product);
        return repository.save(product);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public List<Product> getProductsByName(String name) {
        return repository.findByNameContaining(name);
    }
}