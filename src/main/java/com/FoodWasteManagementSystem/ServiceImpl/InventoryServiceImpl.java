package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.InventoryDto;
import com.FoodWasteManagementSystem.Domain.Inventory;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.InventoryMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.InventoryRepositoryService;
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
        validateInventoryDTO(inventoryDto);
        Inventory entity = mapper.toEntity(inventoryDto);

        return mapper.toDto(repositoryService.createInventory(entity));
    }

    private void validateInventoryDTO(InventoryDto inventoryDto) {
        Objects.requireNonNull(inventoryDto, "inventoryDto can not be null");
        Objects.requireNonNull(inventoryDto.getProductId(), "product id can not be null");
        Objects.requireNonNull(inventoryDto.getSkuCode(), "Sku code can not be null");
        Objects.requireNonNull(inventoryDto.getQuantity(), "qunatity id can not be null");
        Optional.ofNullable(productService.getProductById(inventoryDto.getProductId()))
                .orElseThrow(() -> new ResourceNotFoundException("ID WITH GIVEN PRODUCT NOT FOUND IN THE SKU CODE"));

        if (inventoryDto.getQuantity() <= 0) {
            throw new ResourceNotFoundException("qunatity must be greater the 0");
        }
    }

    @Override
    public InventoryDto updateInventory(InventoryDto inventoryDto) {
        validateInventoryDTO(inventoryDto);
        Inventory serviceInventoryById = repositoryService.getInventoryById(inventoryDto.getId());
        Optional.ofNullable(serviceInventoryById).orElseThrow(() -> new IllegalArgumentException("id not Present"));
        mapper.updateEntityFromDto(inventoryDto, serviceInventoryById);
        return mapper.toDto(repositoryService.updateInventory(serviceInventoryById));
    }

    @Override
    public void deleteInventory(Long id) {
        repositoryService.deleteInventory(id);

    }

    @Override
    public List<InventoryDto> getInventoriesByProductId(Long productId) {
        return repositoryService.getInventoriesByProductId(productId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<InventoryDto> getInventoriesBySkuCode(String skuCode) {
        return repositoryService.getInventoriesBySkuCode(skuCode)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<InventoryDto> getInventoriesByDueDateBetween(LocalDate startDate, LocalDate endDate) {
        return repositoryService.getInventoriesByDueDateBetween(startDate, endDate)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
