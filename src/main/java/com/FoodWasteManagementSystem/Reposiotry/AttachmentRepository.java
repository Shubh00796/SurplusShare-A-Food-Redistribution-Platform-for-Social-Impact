package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    List<Attachment> findByIssueId(Long issueId);

    Optional<Attachment> findByIdAndIssueId(Long id, Long issueId);
}
