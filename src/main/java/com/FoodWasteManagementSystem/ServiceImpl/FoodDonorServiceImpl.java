package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.FoodDonorDto;
import com.FoodWasteManagementSystem.Domain.FoodDonor;
import com.FoodWasteManagementSystem.MapstructMappers.FoodDonorMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.FoodDonorRepositoryService;
import com.FoodWasteManagementSystem.Service.FoodDonorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class FoodDonorServiceImpl implements FoodDonorService {
    private final FoodDonorRepositoryService repositoryService;
    private final FoodDonorMapper mapper;

    @Override
    public List<FoodDonorDto> getAllFoodDonors() {
        return repositoryService.getAllFoodDonors()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FoodDonorDto getFoodDonorById(Long id) {
        FoodDonor serviceFoodDonorById = existingDonourId(id);
        return mapper.toDto(serviceFoodDonorById);
    }

    private FoodDonor existingDonourId(Long id) {
        FoodDonor serviceFoodDonorById = repositoryService.getFoodDonorById(id);
        return serviceFoodDonorById;
    }

    @Override
    public FoodDonorDto createFoodDonor(FoodDonorDto foodDonorDto) {
        Objects.requireNonNull(foodDonorDto);
        FoodDonor entity = mapper.toEntity(foodDonorDto);
        return mapper.toDto(repositoryService.createFoodDonor(entity));
    }

    @Override
    public FoodDonorDto updateFoodDonor(FoodDonorDto foodDonorDto) {
        FoodDonor existingFoodDonourId = existingDonourId(foodDonorDto.getId());
        mapper.updateEntityFromDto(foodDonorDto, existingFoodDonourId);
        return mapper.toDto(repositoryService.updateFoodDonor(existingFoodDonourId));
    }

    @Override
    public void deleteFoodDonor(Long id) {
        repositoryService.deleteFoodDonor(id);
    }
}
