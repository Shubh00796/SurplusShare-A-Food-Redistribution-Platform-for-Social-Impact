package com.FoodWasteManagementSystem.Reposiotry;


import com.FoodWasteManagementSystem.Domain.IssueForPothole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<IssueForPothole, Long> {
    List<IssueForPothole> findByUserId(Long userId);

    IssueForPothole findByIdAndUserId(Long id, Long userId);
}
