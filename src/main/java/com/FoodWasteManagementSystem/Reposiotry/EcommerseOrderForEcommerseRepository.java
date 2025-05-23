package com.FoodWasteManagementSystem.Reposiotry;

import com.FoodWasteManagementSystem.Domain.OrderForEcommerse;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EcommerseOrderForEcommerseRepository extends JpaRepository<OrderForEcommerse, Long> {
    List<OrderForEcommerse> findByCustomerId(Long customerId);

    List<OrderForEcommerse> findByCustomerIdAndOrderDateBetween(Long customerId, LocalDate startDate, LocalDate endDate);
}