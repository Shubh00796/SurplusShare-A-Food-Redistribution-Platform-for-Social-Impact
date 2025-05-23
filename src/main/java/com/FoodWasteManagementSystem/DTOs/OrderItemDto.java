package com.FoodWasteManagementSystem.DTOs;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double subtotal;
}