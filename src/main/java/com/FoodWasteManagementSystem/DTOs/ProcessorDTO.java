package com.FoodWasteManagementSystem.DTOs;

import lombok.Data;

@Data
public class ProcessorDTO {
    private Long id;
    private String name;
    private String location;
    private Double maxProcessingCapacity;
}
