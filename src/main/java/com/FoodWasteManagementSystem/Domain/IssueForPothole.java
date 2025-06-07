package com.FoodWasteManagementSystem.Domain;

import com.FoodWasteManagementSystem.Enums.IssueStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ordersforecom")
@Entity
public class IssueForPothole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String issueType;
    private String location;
    private String description;
    private IssueStatus status;
    private Long userId;
}