package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.MaterialDto;
import com.FoodWasteManagementSystem.Service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/materials")
public class MaterialController {
    private final MaterialService materialService;

    @GetMapping
    public ResponseEntity<List<MaterialDto>> getAllMaterials() {
        return ResponseEntity.ok(materialService.getAllMaterials());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDto> getMaterialById(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.getMaterialById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<MaterialDto> getMaterialByName(@PathVariable String name) {
        return ResponseEntity.ok(materialService.getMaterialByName(name));
    }

    @PostMapping
    public ResponseEntity<MaterialDto> createMaterial(@RequestBody MaterialDto materialDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(materialService.createMaterial(materialDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDto> updateMaterial(@PathVariable Long id, @RequestBody MaterialDto materialDto) {
        materialDto.setId(id);
        return ResponseEntity.ok(materialService.updateMaterial(materialDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}