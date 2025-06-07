package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.Attachment;
import com.FoodWasteManagementSystem.Reposiotry.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class AttachmentRepositoryService {
    private final AttachmentRepository repository;

    public List<Attachment> getAllAttachments() {
        return repository.findAll();
    }

    public Attachment getAttachmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attachment not found with id " + id));
    }

    public Attachment createAttachment(Attachment attachment) {
        Objects.requireNonNull(attachment);
        return repository.save(attachment);
    }

    public Attachment updateAttachment(Attachment attachment) {
        Objects.requireNonNull(attachment);
        return repository.save(attachment);
    }

    public void deleteAttachment(Long id) {
        repository.deleteById(id);
    }

    public List<Attachment> getAttachmentsByIssueId(Long issueId) {
        return repository.findByIssueId(issueId);
    }

    public Attachment getAttachmentByIdAndIssueId(Long id, Long issueId) {
        return repository.findByIdAndIssueId(id, issueId)
                .orElseThrow(() -> new RuntimeException("Attachment not found with id " + id + " and issueId " + issueId));
    }
}