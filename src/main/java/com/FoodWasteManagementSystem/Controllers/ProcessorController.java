package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.ProcessorDTO;
import com.FoodWasteManagementSystem.Service.ProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/processors")
public class ProcessorController {
    private final ProcessorService processorService;

    @GetMapping
    public ResponseEntity<List<ProcessorDTO>> getAllProcessors() {
        List<ProcessorDTO> processorDtos = processorService.getAllProcessors();
        return new ResponseEntity<>(processorDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcessorDTO> getProcessorById(@PathVariable Long id) {
        ProcessorDTO processorDto = processorService.getProcessorById(id);
        return new ResponseEntity<>(processorDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProcessorDTO> createProcessor(@RequestBody ProcessorDTO processorDto) {
        ProcessorDTO createdProcessorDto = processorService.createProcessor(processorDto);
        return new ResponseEntity<>(createdProcessorDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcessorDTO> updateProcessor(@PathVariable Long id, @RequestBody ProcessorDTO processorDto) {
        processorDto.setId(id);
        ProcessorDTO updatedProcessorDto = processorService.updateProcessor(processorDto);
        return new ResponseEntity<>(updatedProcessorDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcessor(@PathVariable Long id) {
        processorService.deleteProcessor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProcessorDTO>> getProcessorsByName(@PathVariable String name) {
        List<ProcessorDTO> processorDtos = processorService.getProcessorsByName(name);
        return new ResponseEntity<>(processorDtos, HttpStatus.OK);
    }
}