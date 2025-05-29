package com.FoodWasteManagementSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductsDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private LocalDate createdAt;
    private Boolean isActive;
}