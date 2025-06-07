package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.IssueDTO;
import com.FoodWasteManagementSystem.DTOs.IssueUpdateDTO;
import com.FoodWasteManagementSystem.Domain.IssueForPothole;
import com.FoodWasteManagementSystem.Enums.IssueStatus;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.IssueFoPoholeMapper;
import com.FoodWasteManagementSystem.Service.IssueService;
import com.FoodWasteManagementSystem.Service.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class IssueServiceImpl implements IssueService {
    private final UserServiceInterface userServiceInterface;
    private final IssueFoPoholeMapper mapper;
    private final com.FoodWasteManagementSystem.RepositoryServices.IssueRepositoryService issueRepositoryService;

    @Override
    public List<IssueDTO> getAllIssues() {
        return issueRepositoryService.getAllIssues()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IssueDTO getIssueById(Long id) {
        IssueForPothole pothole = issueRepositoryService.getIssueById(id);
        return mapper.toDto(pothole);
    }

    @Override
    @Transactional
    public IssueDTO createIssue(IssueDTO issueCreateDTO) {
        Optional.ofNullable(userServiceInterface.getUserById(issueCreateDTO.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("You cant create issue if user id is not present" + issueCreateDTO.getUserId()));
        Objects.requireNonNull(issueCreateDTO.getIssueType(), "issue type can not be null");
        Objects.requireNonNull(issueCreateDTO.getLocation(), "Location can not be null");
        IssueForPothole pothole = mapper.toEntity(issueCreateDTO);
        pothole.setStatus(IssueStatus.Tracked);


        return mapper.toDto(issueRepositoryService.createIssue(pothole));
    }

    @Override
    @Transactional
    public IssueDTO updateIssue(Long id, IssueUpdateDTO issueUpdateDTO) {
        IssueForPothole pothole = issueRepositoryService.getIssueById(id);
        Optional.of(pothole).orElseThrow(() -> new ResourceNotFoundException("you cant update the issue if id is not there" + pothole));
        mapper.updateEntityFromDto(issueUpdateDTO, pothole);
        return mapper.toDto(issueRepositoryService.updateIssue(pothole));
    }

    @Override
    @Transactional
    public void deleteIssue(Long id) {
        issueRepositoryService.deleteIssue(id);

    }

    @Override
    public List<IssueDTO> getIssuesByUserId(Long userId) {
        return issueRepositoryService.getIssuesByUserId(userId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public IssueDTO getIssueByIdAndUserId(Long id, Long userId) {
        IssueForPothole issueByIdAndUserId = issueRepositoryService.getIssueByIdAndUserId(id, userId);
        return mapper.toDto(issueByIdAndUserId);
    }
}
