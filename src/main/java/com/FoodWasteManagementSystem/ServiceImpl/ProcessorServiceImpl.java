package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.ProcessorDTO;
import com.FoodWasteManagementSystem.Domain.Processor;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.ProcessorMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.ProcessorRepositoryService;
import com.FoodWasteManagementSystem.Service.ProcessorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProcessorServiceImpl implements ProcessorService {
    private final ProcessorRepositoryService repositoryService;
    private final ProcessorMapper mapper;

    @Override
    public List<ProcessorDTO> getAllProcessors() {
        return repositoryService.getAllProcessors()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProcessorDTO getProcessorById(Long id) {
        Processor serviceProcessorById = repositoryService.getProcessorById(id);
        return mapper.toDto(serviceProcessorById);
    }

    @Override
    public ProcessorDTO createProcessor(ProcessorDTO processorDto) {
        Objects.requireNonNull(processorDto);
        Processor entity = mapper.toEntity(processorDto);

        return mapper.toDto(repositoryService.createProcessor(entity));
    }

    @Override
    public ProcessorDTO updateProcessor(ProcessorDTO processorDto) {
        Processor repositoryServiceProcessorById = checkIfTheIdIsPresentOrNot(processorDto);
        mapper.updateEntityFromDto(processorDto, repositoryServiceProcessorById);
        return mapper.toDto(repositoryService.updateProcessor(repositoryServiceProcessorById));
    }

    private Processor checkIfTheIdIsPresentOrNot(ProcessorDTO processorDto) {
        Processor repositoryServiceProcessorById = repositoryService.getProcessorById(processorDto.getId());
        if (repositoryServiceProcessorById == null) {
            throw new ResourceNotFoundException("Id with resource not found" + repositoryServiceProcessorById);
        }
        return repositoryServiceProcessorById;
    }

    @Override
    public void deleteProcessor(Long id) {
        repositoryService.deleteProcessor(id);

    }

    @Override
    public List<ProcessorDTO> getProcessorsByName(String name) {
        return repositoryService.getProcessorsByName(name)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
