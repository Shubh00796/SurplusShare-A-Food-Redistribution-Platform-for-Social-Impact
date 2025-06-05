package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.OrderForInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderForInventoryRepository extends JpaRepository<OrderForInventory, Long> {
    OrderForInventory findOrderById(Long orderId);

    List<OrderForInventory> findByIdIn(List<Long> orderIds);

}
