package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.OrderItemDto;

import java.util.List;

public interface OrderItemService {
    List<OrderItemDto> getAllOrderItems();

    OrderItemDto getOrderItemById(Long id);

    OrderItemDto createOrderItem(OrderItemDto orderItemDto);

    OrderItemDto updateOrderItem(OrderItemDto orderItemDto);

    void deleteOrderItem(Long id);

    List<OrderItemDto> getOrderItemsByOrderId(Long orderId);
}