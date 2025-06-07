package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.AttachmentDTO;
import com.FoodWasteManagementSystem.Service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attachments")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentService attachmentService;


    @GetMapping
    public List<AttachmentDTO> getAllAttachments() {
        return attachmentService.getAllAttachments();
    }

    @GetMapping("/{id}")
    public AttachmentDTO getAttachmentById(@PathVariable Long id) {
        return attachmentService.getAttachmentById(id);
    }

    @PostMapping
    public AttachmentDTO createAttachment(@RequestBody AttachmentDTO attachmentDTO) {
        return attachmentService.createAttachment(attachmentDTO);
    }

    @PatchMapping("/{id}")
    public AttachmentDTO updateAttachment(@PathVariable Long id, @RequestBody AttachmentDTO attachmentDTO) {
        return attachmentService.updateAttachment(id, attachmentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAttachment(@PathVariable Long id) {
        attachmentService.deleteAttachment(id);
    }

    @GetMapping("/issue/{issueId}")
    public List<AttachmentDTO> getAttachmentsByIssueId(@PathVariable Long issueId) {
        return attachmentService.getAttachmentsByIssueId(issueId);
    }

    @GetMapping("/{id}/issue/{issueId}")
    public AttachmentDTO getAttachmentByIdAndIssueId(@PathVariable Long id, @PathVariable Long issueId) {
        return attachmentService.getAttachmentByIdAndIssueId(id, issueId);
    }
}