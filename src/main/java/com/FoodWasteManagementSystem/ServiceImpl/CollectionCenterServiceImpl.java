package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.CollectionCenterDto;
import com.FoodWasteManagementSystem.Domain.CollectionCenter;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.CollectionCenterMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.CollectionCenterRepositoryService;
import com.FoodWasteManagementSystem.Service.CollectionCenterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CollectionCenterServiceImpl implements CollectionCenterService {
    private final CollectionCenterRepositoryService repositoryService;
    private final CollectionCenterMapper mapper;

    @Override
    public List<CollectionCenterDto> getAllCollectionCenters() {
        return repositoryService.getAllCollectionCenters()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CollectionCenterDto getCollectionCenterById(Long id) {
        CollectionCenter repositoryServiceCollectionCenterById = getRepositoryServiceCollectionCenterById(id);
        return mapper.toDto(repositoryServiceCollectionCenterById);
    }

    private CollectionCenter getRepositoryServiceCollectionCenterById(Long id) {
        CollectionCenter repositoryServiceCollectionCenterById = repositoryService.getCollectionCenterById(id);
        return repositoryServiceCollectionCenterById;
    }

    @Override
    public CollectionCenterDto createCollectionCenter(CollectionCenterDto collectionCenterDto) {
        Objects.requireNonNull(collectionCenterDto);
        CollectionCenter mapperEntity = mapper.toEntity(collectionCenterDto);
        return mapper.toDto(repositoryService.createCollectionCenter(mapperEntity));
    }

    @Override
    public CollectionCenterDto updateCollectionCenter(CollectionCenterDto collectionCenterDto) {
        Objects.requireNonNull(collectionCenterDto);

        CollectionCenter existingCollectionCenter = getRepositoryServiceCollectionCenterById(collectionCenterDto.getId());
        checkIfCollectionCenterExistsOrNot(existingCollectionCenter);

        mapper.updateEntityFromDto(collectionCenterDto, existingCollectionCenter);
        return mapper.toDto(repositoryService.updateCollectionCenter(existingCollectionCenter));
    }

    private static void checkIfCollectionCenterExistsOrNot(CollectionCenter existingCollectionCenter) {
        if (existingCollectionCenter == null) {
            throw new ResourceNotFoundException("Id with given Collection center not found" + existingCollectionCenter);
        }
    }

    @Override
    public void deleteCollectionCenter(Long id) {
        repositoryService.deleteCollectionCenter(id);

    }

    @Override
    public List<CollectionCenterDto> getCollectionCentersByLocation(String location) {
        return repositoryService.getCollectionCentersByLocation(location)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
