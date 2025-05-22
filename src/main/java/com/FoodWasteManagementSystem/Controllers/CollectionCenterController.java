package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.CollectionCenterDto;
import com.FoodWasteManagementSystem.Service.CollectionCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/collection-centers")
public class CollectionCenterController {
    private final CollectionCenterService collectionCenterService;

    @GetMapping
    public ResponseEntity<List<CollectionCenterDto>> getAllCollectionCenters() {
        List<CollectionCenterDto> collectionCenterDtos = collectionCenterService.getAllCollectionCenters();
        return new ResponseEntity<>(collectionCenterDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectionCenterDto> getCollectionCenterById(@PathVariable Long id) {
        CollectionCenterDto collectionCenterDto = collectionCenterService.getCollectionCenterById(id);
        return new ResponseEntity<>(collectionCenterDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CollectionCenterDto> createCollectionCenter(@RequestBody CollectionCenterDto collectionCenterDto) {
        CollectionCenterDto createdCollectionCenterDto = collectionCenterService.createCollectionCenter(collectionCenterDto);
        return new ResponseEntity<>(createdCollectionCenterDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CollectionCenterDto> updateCollectionCenter(@PathVariable Long id, @RequestBody CollectionCenterDto collectionCenterDto) {
        collectionCenterDto.setId(id);
        CollectionCenterDto updatedCollectionCenterDto = collectionCenterService.updateCollectionCenter(collectionCenterDto);
        return new ResponseEntity<>(updatedCollectionCenterDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollectionCenter(@PathVariable Long id) {
        collectionCenterService.deleteCollectionCenter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<CollectionCenterDto>> getCollectionCentersByLocation(@PathVariable String location) {
        List<CollectionCenterDto> collectionCenterDtos = collectionCenterService.getCollectionCentersByLocation(location);
        return new ResponseEntity<>(collectionCenterDtos, HttpStatus.OK);
    }
}