package com.FoodWasteManagementSystem.ReposiotryServices;


import com.FoodWasteManagementSystem.Domain.OrderForEcommerse;
import com.FoodWasteManagementSystem.Reposiotry.EcommerseOrderForEcommerseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class OrderRepositoryService {
    private final EcommerseOrderForEcommerseRepository repository;

    public List<OrderForEcommerse> getAllOrders() {
        return repository.findAll();
    }

    public OrderForEcommerse getOrderById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    public OrderForEcommerse createOrder(OrderForEcommerse orderForEcommerse) {
        Objects.requireNonNull(orderForEcommerse);
        return repository.save(orderForEcommerse);
    }

    public OrderForEcommerse updateOrder(OrderForEcommerse orderForEcommerse) {
        Objects.requireNonNull(orderForEcommerse);
        return repository.save(orderForEcommerse);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

    public List<OrderForEcommerse> getOrdersByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public List<OrderForEcommerse> getOrdersByCustomerIdAndDateRange(Long customerId, LocalDate startDate, LocalDate endDate) {
        return repository.findByCustomerIdAndOrderDateBetween(customerId, startDate, endDate);
    }
}