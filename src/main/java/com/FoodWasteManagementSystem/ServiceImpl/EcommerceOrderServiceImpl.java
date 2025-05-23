package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.OrderDto;
import com.FoodWasteManagementSystem.DTOs.OrderItemDto;
import com.FoodWasteManagementSystem.Domain.OrderForEcommerse;
import com.FoodWasteManagementSystem.MapstructMappers.OrderMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.OrderRepositoryService;
import com.FoodWasteManagementSystem.Service.EcommerceOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EcommerceOrderServiceImpl implements EcommerceOrderService {
    private final OrderRepositoryService orderRepositoryService;
    private final OrderMapper mapper;

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepositoryService.getAllOrders()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Long id) {
        OrderForEcommerse orderById = orderRepositoryService.getOrderById(id);
        return mapper.toDto(orderById);
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        validateOrderItemDto(orderDto);
        OrderForEcommerse order = mapper.toEntity(orderDto);

        return mapper.toDto(orderRepositoryService.createOrder(order));
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        validateOrderItemDto(orderDto);
        OrderForEcommerse existingOrder = orderRepositoryService.getOrderById(orderDto.getId());
        mapper.updateEntityFromDto(orderDto, existingOrder);
        return mapper.toDto(orderRepositoryService.updateOrder(existingOrder));
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepositoryService.deleteOrder(id);

    }

    @Override
    public List<OrderDto> getOrdersByCustomerId(Long customerId) {
        return orderRepositoryService.getOrdersByCustomerId(customerId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersByCustomerIdAndDateRange(Long customerId, LocalDate startDate, LocalDate endDate) {
        return List.of();
    }

    private static void validateOrderItemDto(OrderDto orderDto) {
        validateOrderItemDtoNotNull(orderDto);
        validateQuantityGreaterThanZero(orderDto);
        Objects.requireNonNull(orderDto.getOrderDate(), "Order date cannot be null");
        Objects.requireNonNull(orderDto.getCustomerId(), "Customers ID cannot be null");
        Objects.requireNonNull(orderDto.getTotal(), "Total cannot be null");


    }

    private static void validateOrderItemDtoNotNull(OrderDto orderDto) {
        if (orderDto == null) {
            throw new NullPointerException("Order item DTO cannot be null");
        }
    }

    private static void validateQuantityGreaterThanZero(OrderDto orderDto) {
        if (orderDto.getTotal() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
    }
}
