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
public class OrderDTOForInventory {
    private Long id;
    private LocalDate orderDate;
    private String customerName;
    private String contactEmail;
    private BigDecimal totalCost;
    private Boolean isShipped;
}
