package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.OrderDto;

import java.time.LocalDate;
import java.util.List;

public interface EcommerceOrderService {

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(Long id);

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(OrderDto orderDto);

    void deleteOrder(Long id);

    List<OrderDto> getOrdersByCustomerId(Long customerId);

    List<OrderDto> getOrdersByCustomerIdAndDateRange(Long customerId, LocalDate startDate, LocalDate endDate);
}
