package com.FoodWasteManagementSystem.MapstructMappers;

import com.FoodWasteManagementSystem.DTOs.AttachmentDTO;
import com.FoodWasteManagementSystem.DTOs.IssueDTO;
import com.FoodWasteManagementSystem.DTOs.IssueUpdateDTO;
import com.FoodWasteManagementSystem.Domain.Attachment;
import com.FoodWasteManagementSystem.Domain.IssueForPothole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {
    AttachmentDTO toDto(Attachment attachment);

    Attachment toEntity(AttachmentDTO attachmentDTO);

    @Mapping(target = "issueId", ignore = true)
    void updateEntityFromDto(AttachmentDTO attachmentDTO, @MappingTarget Attachment attachment);

}
