package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.OrderDto;
import com.FoodWasteManagementSystem.Service.EcommerceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class EcommerceOrderController {
    private final EcommerceOrderService ecommerceOrderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtos = ecommerceOrderService.getAllOrders();
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        OrderDto orderDto = ecommerceOrderService.getOrderById(id);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto createdOrderDto = ecommerceOrderService.createOrder(orderDto);
        return new ResponseEntity<>(createdOrderDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        orderDto.setId(id);
        OrderDto updatedOrderDto = ecommerceOrderService.updateOrder(orderDto);
        return new ResponseEntity<>(updatedOrderDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        ecommerceOrderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomerId(@PathVariable Long customerId) {
        List<OrderDto> orderDtos = ecommerceOrderService.getOrdersByCustomerId(customerId);
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}/date-range")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomerIdAndDateRange(@PathVariable Long customerId, @RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        List<OrderDto> orderDtos = ecommerceOrderService.getOrdersByCustomerIdAndDateRange(customerId, startDate, endDate);
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }
}