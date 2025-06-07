package com.FoodWasteManagementSystem.Domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attachments_for_Issues")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    private Long issueId;
}