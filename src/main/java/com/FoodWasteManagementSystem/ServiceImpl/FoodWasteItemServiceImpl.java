package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.FoodWasteItemDto;
import com.FoodWasteManagementSystem.Domain.FoodWasteItem;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.FoodWasteItemMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.FoodDonorRepositoryService;
import com.FoodWasteManagementSystem.ReposiotryServices.FoodWasteItemRepositoryService;
import com.FoodWasteManagementSystem.Service.FoodWasteItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class FoodWasteItemServiceImpl implements FoodWasteItemService {
    private final FoodWasteItemRepositoryService repositoryService;
    private final FoodWasteItemMapper mapper;
    private final FoodDonorRepositoryService donorRepositoryService;

    @Override
    public List<FoodWasteItemDto> getAllFoodWasteItems() {
        return repositoryService.getAllFoodWasteItems()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FoodWasteItemDto getFoodWasteItemById(Long id) {
        FoodWasteItem serviceFoodWasteItemById = getFoodWasteItem(id);
        return mapper.toDto(serviceFoodWasteItemById);
    }

    private FoodWasteItem getFoodWasteItem(Long id) {
        FoodWasteItem serviceFoodWasteItemById = existingWasteItemId(id);
        return serviceFoodWasteItemById;
    }

    private FoodWasteItem existingWasteItemId(Long id) {
        FoodWasteItem serviceFoodWasteItemById = repositoryService.getFoodWasteItemById(id);
        return serviceFoodWasteItemById;
    }

    @Override
    public FoodWasteItemDto createFoodWasteItem(FoodWasteItemDto foodWasteItemDto) {
        getFoodDonourByTheID(foodWasteItemDto);

        Objects.requireNonNull(foodWasteItemDto);
        FoodWasteItem entity = mapper.toEntity(foodWasteItemDto);
        return mapper.toDto(repositoryService.createFoodWasteItem(entity));
    }

    private void getFoodDonourByTheID(FoodWasteItemDto foodWasteItemDto) {
        if (donorRepositoryService.getFoodDonorById(foodWasteItemDto.getFoodDonorId()) == null) {
            throw new ResourceNotFoundException("Food donor not found with id " + foodWasteItemDto.getFoodDonorId());
        }
    }

    @Override
    public FoodWasteItemDto updateFoodWasteItem(FoodWasteItemDto foodWasteItemDto) {
        FoodWasteItem serviceFoodWasteItemById = repositoryService.getFoodWasteItemById(foodWasteItemDto.getId());
        Objects.requireNonNull(foodWasteItemDto);
        mapper.updateEntityFromDto(foodWasteItemDto, serviceFoodWasteItemById);
        return mapper.toDto(repositoryService.createFoodWasteItem(serviceFoodWasteItemById));
    }

    @Override
    public void deleteFoodWasteItem(Long id) {
        repositoryService.deleteFoodWasteItem(id);
    }

    @Override
    public List<FoodWasteItemDto> getFoodWasteItemsByFoodDonorId(Long foodDonorId) {
        return repositoryService.getFoodWasteItemsByFoodDonorId(foodDonorId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}