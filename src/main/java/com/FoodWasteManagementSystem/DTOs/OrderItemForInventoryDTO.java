package com.FoodWasteManagementSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemForInventoryDTO {
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private BigDecimal subtotal;
}
