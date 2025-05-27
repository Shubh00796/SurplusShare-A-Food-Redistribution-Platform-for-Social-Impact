package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.ToolDto;
import com.FoodWasteManagementSystem.Domain.ToolEntity;
import com.FoodWasteManagementSystem.MapstructMappers.ToolMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.ToolRepositoryService;
import com.FoodWasteManagementSystem.Service.ToolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ToolServiceImpl implements ToolService {
    private final ToolRepositoryService repositoryService;
    private final ToolMapper mapper;

    @Override
    public List<ToolDto> getAllTools() {
        return repositoryService.getAllTools().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ToolDto getToolById(Long id) {
        ToolEntity serviceToolById = repositoryService.getToolById(id);
        return mapper.toDto(serviceToolById);
    }

    @Override
    public ToolDto getToolByName(String name) {
        Objects.requireNonNull(name, "name can not be null");
        String lowerCase = name.trim().toLowerCase();
        ToolEntity toolByname = repositoryService.getToolByname(lowerCase);
        return mapper.toDto(toolByname);
    }

    @Override
    public ToolDto createTool(ToolDto toolDto) {
        validateToodlDto(toolDto);
        ToolEntity toolEntity = mapper.toEntity(toolDto);
        return mapper.toDto(repositoryService.createTool(toolEntity));
    }

    private static void validateToodlDto(ToolDto toolDto) {
        Objects.requireNonNull(toolDto, "Tool dto can not be null");
        Objects.requireNonNull(toolDto.getName(), "name can not be null");
        if (toolDto.getName().length() < 3 || toolDto.getName().length() > 50) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name must be between 3 and 50 characters long");
        }
    }

    @Override
    public ToolDto updateTool(ToolDto toolDto) {
        ToolEntity toolEntity = repositoryService.getToolById(toolDto.getId());
        if (toolEntity == null) {
            throw new IllegalArgumentException("Id can not be Null");
        }
        mapper.updateEntityFromDto(toolDto, toolEntity);
        return mapper.toDto(repositoryService.updateTool(toolEntity));
    }

    @Override
    public void deleteTool(Long id) {
        repositoryService.deleteTool(id);

    }
}
