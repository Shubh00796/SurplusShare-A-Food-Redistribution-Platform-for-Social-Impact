package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.AttachmentDTO;
import com.FoodWasteManagementSystem.Domain.Attachment;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.AttachmentMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.AttachmentRepositoryService;
import com.FoodWasteManagementSystem.Service.AttachmentService;
import com.FoodWasteManagementSystem.Service.IssueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepositoryService repositoryService;
    private final AttachmentMapper mapper;
    private final IssueService issueService;

    @Override
    public List<AttachmentDTO> getAllAttachments() {
        return repositoryService.getAllAttachments()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AttachmentDTO getAttachmentById(Long id) {
        Attachment attachment = repositoryService.getAttachmentById(id);

        return mapper.toDto(attachment);
    }

    @Override
    @Transactional
    public AttachmentDTO createAttachment(AttachmentDTO attachmentDTO) {
        Optional.ofNullable(issueService.getIssueById(attachmentDTO.getIssueId()))
                .orElseThrow(() -> new IllegalArgumentException("you cant create attchment if you dont have issue id" + attachmentDTO.getIssueId()));
        Objects.requireNonNull(attachmentDTO.getFileName(), "Filename can not be null");
        Attachment attachment = mapper.toEntity(attachmentDTO);
        return mapper.toDto(repositoryService.createAttachment(attachment));
    }

    @Override
    @Transactional
    public AttachmentDTO updateAttachment(Long id, AttachmentDTO attachmentDTO) {
        Attachment attachment = repositoryService.getAttachmentById(id);
        Optional.ofNullable(attachment).orElseThrow(() -> new ResourceNotFoundException("id can not be null" + attachment));
        mapper.updateEntityFromDto(attachmentDTO, attachment);
        return mapper.toDto(repositoryService.updateAttachment(attachment));
    }

    @Override
    @Transactional
    public void deleteAttachment(Long id) {
        repositoryService.deleteAttachment(id);

    }

    @Override
    public List<AttachmentDTO> getAttachmentsByIssueId(Long issueId) {
        return repositoryService.getAttachmentsByIssueId(issueId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public AttachmentDTO getAttachmentByIdAndIssueId(Long id, Long issueId) {
        Attachment attachment = repositoryService.getAttachmentByIdAndIssueId(id, issueId);
        return mapper.toDto(attachment);
    }
}
