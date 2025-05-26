package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.FoodWasteItemProcessorDto;
import com.FoodWasteManagementSystem.Domain.FoodWasteItemProcessor;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.FoodWasteItemProcessorMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.FoodWasteItemProcessorRepositoryService;
import com.FoodWasteManagementSystem.Service.FoodWasteItemProcessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodWasteItemProcessorServiceImpl implements FoodWasteItemProcessorService {
    private final FoodWasteItemProcessorRepositoryService repositoryService;
    private final FoodWasteItemProcessorMapper mapper;

    @Override
    public List<FoodWasteItemProcessorDto> getAllFoodWasteItemProcessors() {
        return repositoryService.getAllFoodWasteItemProcessors()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FoodWasteItemProcessorDto getFoodWasteItemProcessorById(Long id) {
        FoodWasteItemProcessor foodWasteItemProcessorById = repositoryService.getFoodWasteItemProcessorById(id);
        return mapper.toDto(foodWasteItemProcessorById);
    }

    @Override
    public FoodWasteItemProcessorDto createFoodWasteItemProcessor(FoodWasteItemProcessorDto foodWasteItemProcessorDto) {

        Objects.requireNonNull(foodWasteItemProcessorDto, "foodWasteItemProcessorDto can not be null");
        FoodWasteItemProcessor mapperEntity = mapper.toEntity(foodWasteItemProcessorDto);
        return mapper.toDto(repositoryService.createFoodWasteItemProcessor(mapperEntity));
    }

    @Override
    public FoodWasteItemProcessorDto updateFoodWasteItemProcessor(FoodWasteItemProcessorDto foodWasteItemProcessorDto) {
        Objects.requireNonNull(foodWasteItemProcessorDto, "foodWasteItemProcessorDto can not be null here");
        checkIfIdIsExistsOrNot(foodWasteItemProcessorDto);
        FoodWasteItemProcessor mapperEntity = mapper.toEntity(foodWasteItemProcessorDto);
        mapper.updateEntityFromDto(foodWasteItemProcessorDto, mapperEntity);
        FoodWasteItemProcessor foodWasteItemProcessor = repositoryService.updateFoodWasteItemProcessor(mapperEntity);


        return mapper.toDto(foodWasteItemProcessor);
    }

    private void checkIfIdIsExistsOrNot(FoodWasteItemProcessorDto foodWasteItemProcessorDto) {
        FoodWasteItemProcessor existingId = repositoryService.getFoodWasteItemProcessorById(foodWasteItemProcessorDto.getId());
        if (existingId == null) {
            throw new ResourceNotFoundException("Id with given resource not found" + existingId);
        }
    }

    @Override
    public void deleteFoodWasteItemProcessor(Long id) {
        repositoryService.deleteFoodWasteItemProcessor(id);

    }

    @Override
    public List<FoodWasteItemProcessorDto> getFoodWasteItemProcessorsByFoodWasteItemId(Long foodWasteItemId) {
        return repositoryService.getFoodWasteItemProcessorsByFoodWasteItemId(foodWasteItemId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodWasteItemProcessorDto> getFoodWasteItemProcessorsByProcessorId(Long processorId) {
        return repositoryService.getFoodWasteItemProcessorsByProcessorId(processorId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
