package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Optional<OrderItem> findByOrderIdAndProductId(Long orderId, Long productId);

    List<OrderItem> findByOrderId(Long orderId);
}