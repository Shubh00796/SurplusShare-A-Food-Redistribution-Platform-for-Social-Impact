package com.FoodWasteManagementSystem.DTOs;

import com.FoodWasteManagementSystem.Enums.IssueStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueDTO {
    private Long id;
    private String issueType;
    private String location;
    private String description;
    private IssueStatus status;
    private Long userId;
}