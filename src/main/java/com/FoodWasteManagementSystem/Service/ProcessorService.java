package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.ProcessorDTO;

import java.util.List;

public interface ProcessorService {
    List<ProcessorDTO> getAllProcessors();
    ProcessorDTO getProcessorById(Long id);
    ProcessorDTO createProcessor(ProcessorDTO processorDto);
    ProcessorDTO updateProcessor(ProcessorDTO processorDto);
    void deleteProcessor(Long id);
    List<ProcessorDTO> getProcessorsByName(String name);
}