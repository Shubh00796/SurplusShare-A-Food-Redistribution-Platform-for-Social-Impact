package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.CollectionCenter;
import com.FoodWasteManagementSystem.Reposiotry.CollectionCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class CollectionCenterRepositoryService {
    private final CollectionCenterRepository repository;

    public List<CollectionCenter> getAllCollectionCenters() {
        return repository.findAll();
    }

    public CollectionCenter getCollectionCenterById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Collection center not found with id " + id));
    }

    public CollectionCenter createCollectionCenter(CollectionCenter collectionCenter) {
        Objects.requireNonNull(collectionCenter);
        return repository.save(collectionCenter);
    }

    public CollectionCenter updateCollectionCenter(CollectionCenter collectionCenter) {
        Objects.requireNonNull(collectionCenter);
        return repository.save(collectionCenter);
    }

    public void deleteCollectionCenter(Long id) {
        repository.deleteById(id);
    }

    public List<CollectionCenter> getCollectionCentersByLocation(String location) {
        return repository.findByLocationContaining(location);
    }
}