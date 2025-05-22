package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.Processor;
import com.FoodWasteManagementSystem.Reposiotry.ProcessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class ProcessorRepositoryService {
    private final ProcessorRepository repository;

    public List<Processor> getAllProcessors() {
        return repository.findAll();
    }

    public Processor getProcessorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Processor not found with id " + id));
    }

    public Processor createProcessor(Processor processor) {
        Objects.requireNonNull(processor);
        return repository.save(processor);
    }

    public Processor updateProcessor(Processor processor) {
        Objects.requireNonNull(processor);
        return repository.save(processor);
    }

    public void deleteProcessor(Long id) {
        repository.deleteById(id);
    }

    public List<Processor> getProcessorsByName(String name) {
        return repository.findByNameContaining(name);
    }
}