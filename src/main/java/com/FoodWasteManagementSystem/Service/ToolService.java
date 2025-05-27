package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.ToolDto;

import java.util.List;

public interface ToolService {
    List<ToolDto> getAllTools();

    ToolDto getToolById(Long id);

    ToolDto getToolByName(String name);

    ToolDto createTool(ToolDto toolDto);

    ToolDto updateTool(ToolDto toolDto);

    void deleteTool(Long id);
}