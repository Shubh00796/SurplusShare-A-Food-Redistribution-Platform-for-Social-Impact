package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.FoodWasteItemCollectionCenterDto;
import com.FoodWasteManagementSystem.Domain.CollectionCenter;
import com.FoodWasteManagementSystem.Domain.FoodWasteItemCollectionCenter;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.FoodWasteItemCollectionCenterMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.CollectionCenterRepositoryService;
import com.FoodWasteManagementSystem.ReposiotryServices.FoodWasteItemCollectionCenterRepositoryService;
import com.FoodWasteManagementSystem.Service.FoodWasteItemCollectionCenterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodWasteItemCollectionCenterServiceImpl implements FoodWasteItemCollectionCenterService {
    private final FoodWasteItemCollectionCenterRepositoryService repositoryService;
    private final FoodWasteItemCollectionCenterMapper mapper;
    private final CollectionCenterRepositoryService collectionCenterRepositoryService;

    @Override
    public List<FoodWasteItemCollectionCenterDto> getAllFoodWasteItemCollectionCenters() {
        return repositoryService.getAllFoodWasteItemCollectionCenters()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FoodWasteItemCollectionCenterDto getFoodWasteItemCollectionCenterById(Long id) {
        FoodWasteItemCollectionCenter foodWasteItemCollectionCenterById = repositoryService.getFoodWasteItemCollectionCenterById(id);
        return mapper.toDto(foodWasteItemCollectionCenterById);
    }

    @Override
    public FoodWasteItemCollectionCenterDto createFoodWasteItemCollectionCenter(FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto) {
        checkIfTheCollectionCenterIsPresentOrNot(foodWasteItemCollectionCenterDto);
        Objects.requireNonNull(foodWasteItemCollectionCenterDto, "foodWasteItemCollectionCenterDto can not be null");
        FoodWasteItemCollectionCenter foodWasteItemCollectionCenter = mapper.toEntity(foodWasteItemCollectionCenterDto);
        return mapper.toDto(repositoryService.createFoodWasteItemCollectionCenter(foodWasteItemCollectionCenter));
    }

    private void checkIfTheCollectionCenterIsPresentOrNot(FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto) {
        CollectionCenter repositoryServiceCollectionCenterById = collectionCenterRepositoryService.getCollectionCenterById(foodWasteItemCollectionCenterDto.getCollectionCenterId());
        if (repositoryServiceCollectionCenterById == null) {
            throw new ResourceNotFoundException("Collection id  must not be null" + repositoryServiceCollectionCenterById);
        }
    }

    @Override
    public FoodWasteItemCollectionCenterDto updateFoodWasteItemCollectionCenter(FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto) {
        checkIfFoodWasteTCollectionIsPresent(foodWasteItemCollectionCenterDto);
        Objects.requireNonNull(foodWasteItemCollectionCenterDto, "foodWasteItemCollectionCenterDto can not be null");
        FoodWasteItemCollectionCenter existingFoodWasteItemCollectionCenter = repositoryService.getFoodWasteItemCollectionCenterById(foodWasteItemCollectionCenterDto.getId());
        mapper.updateEntityFromDto(foodWasteItemCollectionCenterDto, existingFoodWasteItemCollectionCenter);
        return mapper.toDto(repositoryService.updateFoodWasteItemCollectionCenter(existingFoodWasteItemCollectionCenter));
    }

    private void checkIfFoodWasteTCollectionIsPresent(FoodWasteItemCollectionCenterDto foodWasteItemCollectionCenterDto) {
        FoodWasteItemCollectionCenter existingId = repositoryService.getFoodWasteItemCollectionCenterById(foodWasteItemCollectionCenterDto.getId());
        if(existingId == null ){
            throw new ResourceNotFoundException("Food waste collection center not found for given id" + existingId);
        }
    }

    @Override
    public void deleteFoodWasteItemCollectionCenter(Long id) {
        repositoryService.deleteFoodWasteItemCollectionCenter(id);
    }

    @Override
    public List<FoodWasteItemCollectionCenterDto> getFoodWasteItemCollectionCentersByFoodWasteItemId(Long foodWasteItemId) {
        List<FoodWasteItemCollectionCenter> foodWasteItemCollectionCenters = repositoryService.getFoodWasteItemCollectionCentersByFoodWasteItemId(foodWasteItemId);
        return foodWasteItemCollectionCenters.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<FoodWasteItemCollectionCenterDto> getFoodWasteItemCollectionCentersByCollectionCenterId(Long collectionCenterId) {
        List<FoodWasteItemCollectionCenter> foodWasteItemCollectionCenters = repositoryService.getFoodWasteItemCollectionCentersByCollectionCenterId(collectionCenterId);
        return foodWasteItemCollectionCenters.stream().map(mapper::toDto).collect(Collectors.toList());
    }
}