package com.FoodWasteManagementSystem.RepositoryServices;

import com.FoodWasteManagementSystem.Domain.IssueForPothole;
import com.FoodWasteManagementSystem.Reposiotry.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class IssueRepositoryService {
    private final IssueRepository repository;

    public List<IssueForPothole> getAllIssues() {
        return repository.findAll();
    }

    public IssueForPothole getIssueById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found with id " + id));
    }

    public IssueForPothole createIssue(IssueForPothole issue) {
        Objects.requireNonNull(issue);
        return repository.save(issue);
    }

    public IssueForPothole updateIssue(IssueForPothole issue) {
        Objects.requireNonNull(issue);
        return repository.save(issue);
    }

    public void deleteIssue(Long id) {
        repository.deleteById(id);
    }

    public List<IssueForPothole> getIssuesByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public IssueForPothole getIssueByIdAndUserId(Long id, Long userId) {
        return repository.findByIdAndUserId(id, userId);

    }
}