package com.FoodWasteManagementSystem.Service;


import com.FoodWasteManagementSystem.DTOs.IssueDTO;
import com.FoodWasteManagementSystem.DTOs.IssueUpdateDTO;

import java.util.List;

public interface IssueService {
    List<IssueDTO> getAllIssues();

    IssueDTO getIssueById(Long id);

    IssueDTO createIssue(IssueDTO issueCreateDTO);

    IssueDTO updateIssue(Long id, IssueUpdateDTO issueUpdateDTO);

    void deleteIssue(Long id);

    List<IssueDTO> getIssuesByUserId(Long userId);

    IssueDTO getIssueByIdAndUserId(Long id, Long userId);
}