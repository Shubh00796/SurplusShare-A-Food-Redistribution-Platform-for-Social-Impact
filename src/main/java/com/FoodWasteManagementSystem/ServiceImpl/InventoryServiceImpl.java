package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.InventoryDto;
import com.FoodWasteManagementSystem.DTOs.OrderItemDto;
import com.FoodWasteManagementSystem.Domain.Inventory;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.InventoryMapper;
import com.FoodWasteManagementSystem.Reposiotry.InventoryRepositoryService;
import com.FoodWasteManagementSystem.Service.InventoryService;
import com.FoodWasteManagementSystem.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepositoryService repositoryService;
    private final InventoryMapper mapper;
    private final ProductService productService;

    @Override
    public List<InventoryDto> getAllInventories() {
        return repositoryService.getAllInventories()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public InventoryDto getInventoryById(Long id) {
        Inventory serviceInventoryById = repositoryService.getInventoryById(id);
        return mapper.toDto(serviceInventoryById);
    }

    @Override
    public InventoryDto createInventory(InventoryDto inventoryDto) {
        Objects.requireNonNull(inventoryDto.getProductId(), "product id can not be null");
        Objects.requireNonNull(inventoryDto.getSkuCode(), "Sku code can not be null");
        Objects.requireNonNull(inventoryDto.getQuantity(), "qunatity id can not be null");
        Optional.ofNullable(productService.getProductById(inventoryDto.getProductId()))
                .orElseThrow(() -> new ResourceNotFoundException("ID WITH GIVEN PRODUCT NOT FOUND IN THE SKU CODE"));
        Inventory entity = mapper.toEntity(inventoryDto);

        return mapper.toDto(repositoryService.createInventory(entity));
    }

    @Override
    public InventoryDto updateInventory(InventoryDto inventoryDto) {
        return null;
    }

    @Override
    public void deleteInventory(Long id) {

    }

    @Override
    public List<InventoryDto> getInventoriesByProductId(Long productId) {
        return List.of();
    }

    @Override
    public List<InventoryDto> getInventoriesBySkuCode(String skuCode) {
        return List.of();
    }

    @Override
    public List<InventoryDto> getInventoriesByDueDateBetween(LocalDate startDate, LocalDate endDate) {
        return List.of();
    }
}
