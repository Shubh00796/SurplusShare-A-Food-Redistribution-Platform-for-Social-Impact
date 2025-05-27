package com.FoodWasteManagementSystem.DTOs;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaterialDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal quantity;
    private BigDecimal weight;

}