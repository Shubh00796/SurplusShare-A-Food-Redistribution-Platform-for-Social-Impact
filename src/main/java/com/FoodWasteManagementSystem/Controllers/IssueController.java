package com.FoodWasteManagementSystem.Controllers;


import com.FoodWasteManagementSystem.DTOs.IssueDTO;
import com.FoodWasteManagementSystem.DTOs.IssueUpdateDTO;
import com.FoodWasteManagementSystem.Service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/issues")
public class IssueController {
    private final IssueService issueService;

    @GetMapping
    public ResponseEntity<List<IssueDTO>> getAllIssues() {
        List<IssueDTO> issueDtos = issueService.getAllIssues();
        return new ResponseEntity<>(issueDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDTO> getIssueById(@PathVariable Long id) {
        IssueDTO issueDto = issueService.getIssueById(id);
        return new ResponseEntity<>(issueDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IssueDTO> createIssue(@RequestBody IssueDTO issueDto) {
        IssueDTO createdIssueDto = issueService.createIssue(issueDto);
        return new ResponseEntity<>(createdIssueDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IssueDTO> updateIssue(@PathVariable Long id, @RequestBody IssueUpdateDTO issueUpdateDto) {
        IssueDTO updatedIssueDto = issueService.updateIssue(id, issueUpdateDto);
        return new ResponseEntity<>(updatedIssueDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssue(@PathVariable Long id) {
        issueService.deleteIssue(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<IssueDTO>> getIssuesByUserId(@PathVariable Long userId) {
        List<IssueDTO> issueDtos = issueService.getIssuesByUserId(userId);
        return new ResponseEntity<>(issueDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}/user/{userId}")
    public ResponseEntity<IssueDTO> getIssueByIdAndUserId(@PathVariable Long id, @PathVariable Long userId) {
        IssueDTO issueDto = issueService.getIssueByIdAndUserId(id, userId);
        return new ResponseEntity<>(issueDto, HttpStatus.OK);
    }
}