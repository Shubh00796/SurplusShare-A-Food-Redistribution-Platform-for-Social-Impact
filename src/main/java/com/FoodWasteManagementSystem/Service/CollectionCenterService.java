package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.CollectionCenterDto;

import java.util.List;

public interface CollectionCenterService {
    List<CollectionCenterDto> getAllCollectionCenters();

    CollectionCenterDto getCollectionCenterById(Long id);

    CollectionCenterDto createCollectionCenter(CollectionCenterDto collectionCenterDto);

    CollectionCenterDto updateCollectionCenter(CollectionCenterDto collectionCenterDto);

    void deleteCollectionCenter(Long id);

    List<CollectionCenterDto> getCollectionCentersByLocation(String location);
}
