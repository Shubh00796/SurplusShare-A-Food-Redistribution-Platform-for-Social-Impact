package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.StructureDto;
import com.FoodWasteManagementSystem.Service.StructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/structures")
public class StructureController {
    private final StructureService structureService;

    @GetMapping
    public ResponseEntity<List<StructureDto>> getAllStructures() {
        List<StructureDto> structureDtos = structureService.getAllStructures();
        return new ResponseEntity<>(structureDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructureDto> getStructureById(@PathVariable Long id) {
        StructureDto structureDto = structureService.getStructureById(id);
        return new ResponseEntity<>(structureDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StructureDto> createStructure(@RequestBody StructureDto structureDto) {
        StructureDto createdStructureDto = structureService.createStructure(structureDto);
        return new ResponseEntity<>(createdStructureDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructureDto> updateStructure(@PathVariable Long id, @RequestBody StructureDto structureDto) {
        structureDto.setId(id);
        StructureDto updatedStructureDto = structureService.updateStructure(structureDto);
        return new ResponseEntity<>(updatedStructureDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStructure(@PathVariable Long id) {
        structureService.deleteStructure(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/tool/{toolId}")
    public ResponseEntity<StructureDto> getStructureByToolId(@PathVariable Long toolId) {
        StructureDto structureDto = structureService.getStructureByToolId(toolId);
        return new ResponseEntity<>(structureDto, HttpStatus.OK);
    }

    @GetMapping("/material/{materialId}")
    public ResponseEntity<StructureDto> getStructureByMaterialId(@PathVariable Long materialId) {
        StructureDto structureDto = structureService.getStructureByMaterialId(materialId);
        return new ResponseEntity<>(structureDto, HttpStatus.OK);
    }
}