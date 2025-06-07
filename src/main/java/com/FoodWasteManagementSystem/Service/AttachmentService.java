package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.AttachmentDTO;


import java.util.List;

public interface AttachmentService {
    List<AttachmentDTO> getAllAttachments();

    AttachmentDTO getAttachmentById(Long id);

    AttachmentDTO createAttachment(AttachmentDTO attachmentDTO);

    AttachmentDTO updateAttachment(Long id, AttachmentDTO attachmentDTO);

    void deleteAttachment(Long id);

    List<AttachmentDTO> getAttachmentsByIssueId(Long issueId);

    AttachmentDTO getAttachmentByIdAndIssueId(Long id, Long issueId);
}