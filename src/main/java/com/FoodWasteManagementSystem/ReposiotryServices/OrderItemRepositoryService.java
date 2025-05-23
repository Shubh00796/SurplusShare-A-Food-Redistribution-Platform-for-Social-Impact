package com.FoodWasteManagementSystem.ReposiotryServices;

import com.FoodWasteManagementSystem.Domain.OrderItem;
import com.FoodWasteManagementSystem.Reposiotry.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class OrderItemRepositoryService {
    private final OrderItemRepository repository;

    public List<OrderItem> getAllOrderItems() {
        return repository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order item not found with id " + id));
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        Objects.requireNonNull(orderItem);
        return repository.save(orderItem);
    }

    public OrderItem updateOrderItem(OrderItem orderItem) {
        Objects.requireNonNull(orderItem);
        return repository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        repository.deleteById(id);
    }

    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return repository.findByOrderId(orderId);
    }
}