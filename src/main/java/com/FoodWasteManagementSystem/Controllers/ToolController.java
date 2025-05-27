package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.ToolDto;
import com.FoodWasteManagementSystem.Service.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tools")
public class ToolController {
    private final ToolService toolService;

    @GetMapping
    public ResponseEntity<List<ToolDto>> getAllTools() {
        return ResponseEntity.ok(toolService.getAllTools());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToolDto> getToolById(@PathVariable Long id) {
        return ResponseEntity.ok(toolService.getToolById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ToolDto> getToolByName(@PathVariable String name) {
        return ResponseEntity.ok(toolService.getToolByName(name));
    }

    @PostMapping
    public ResponseEntity<ToolDto> createTool(@RequestBody ToolDto toolDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toolService.createTool(toolDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToolDto> updateTool(@PathVariable Long id, @RequestBody ToolDto toolDto) {
        toolDto.setId(id);
        return ResponseEntity.ok(toolService.updateTool(toolDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTool(@PathVariable Long id) {
        toolService.deleteTool(id);
        return ResponseEntity.noContent().build();
    }
}