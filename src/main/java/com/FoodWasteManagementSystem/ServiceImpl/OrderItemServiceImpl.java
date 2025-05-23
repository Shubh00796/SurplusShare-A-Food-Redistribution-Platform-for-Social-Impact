package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.OrderItemDto;
import com.FoodWasteManagementSystem.Domain.OrderItem;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.OrderItemMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.OrderItemRepositoryService;
import com.FoodWasteManagementSystem.Service.EcommerceOrderService;
import com.FoodWasteManagementSystem.Service.OrderItemService;
import com.FoodWasteManagementSystem.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepositoryService repositoryService;
    private final OrderItemMapper mapper;
    private final EcommerceOrderService ecommerceOrderService;
    private final ProductService productService;

    @Override
    public List<OrderItemDto> getAllOrderItems() {
        return repositoryService.getAllOrderItems()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDto getOrderItemById(Long id) {
        OrderItem itemById = repositoryService.getOrderItemById(id);
        return mapper.toDto(itemById);
    }

    @Override
    public OrderItemDto createOrderItem(OrderItemDto orderItemDto) {
        validateProductAndOrderId(orderItemDto);
        validateOrderItemDto(orderItemDto);

        OrderItem entity = mapper.toEntity(orderItemDto);


        return mapper.toDto(repositoryService.createOrderItem(entity));
    }

    private void validateProductAndOrderId(OrderItemDto orderItemDto) {
        Optional.ofNullable(ecommerceOrderService.getOrderById(orderItemDto.getOrderId())).orElseThrow(() -> new ResolutionException("Order id can not be null" + orderItemDto.getOrderId()));
        Optional.ofNullable(productService.getProductById(orderItemDto.getProductId())).orElseThrow(() -> new ResourceNotFoundException("Product id and not be null or empty" + orderItemDto.getProductId()));
    }

    private static void validateOrderItemDto(OrderItemDto orderItemDto) {
        validateOrderItemDtoNotNull(orderItemDto);
        validateQuantityGreaterThanZero(orderItemDto);
        Objects.requireNonNull(orderItemDto.getOrderId(), "Order ID cannot be null");
        Objects.requireNonNull(orderItemDto.getProductId(), "Product ID cannot be null");
        Objects.requireNonNull(orderItemDto.getQuantity(), "Quantity cannot be null");


    }

    private static void validateOrderItemDtoNotNull(OrderItemDto orderItemDto) {
        if (orderItemDto == null) {
            throw new NullPointerException("Order item DTO cannot be null");
        }
    }

    private static void validateQuantityGreaterThanZero(OrderItemDto orderItemDto) {
        if (orderItemDto.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
    }


    @Override
    public OrderItemDto updateOrderItem(OrderItemDto orderItemDto) {
        validateOrderItemDto(orderItemDto);
        OrderItem existingorderItem = repositoryService.getOrderItemById(orderItemDto.getId());
        mapper.updateEntityFromDto(orderItemDto, existingorderItem);
        return mapper.toDto(repositoryService.updateOrderItem(existingorderItem));
    }

    @Override
    public void deleteOrderItem(Long id) {
        repositoryService.deleteOrderItem(id);

    }

    @Override
    public List<OrderItemDto> getOrderItemsByOrderId(Long orderId) {
        return repositoryService.getOrderItemsByOrderId(orderId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
