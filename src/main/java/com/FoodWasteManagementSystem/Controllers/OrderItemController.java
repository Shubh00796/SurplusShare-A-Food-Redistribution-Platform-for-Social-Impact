package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.OrderItemDto;
import com.FoodWasteManagementSystem.Service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/order-items")
public class OrderItemController {
    private final OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItemDto>> getAllOrderItems() {
        List<OrderItemDto> orderItemDtos = orderItemService.getAllOrderItems();
        return new ResponseEntity<>(orderItemDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDto> getOrderItemById(@PathVariable Long id) {
        OrderItemDto orderItemDto = orderItemService.getOrderItemById(id);
        return new ResponseEntity<>(orderItemDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@RequestBody OrderItemDto orderItemDto) {
        OrderItemDto createdOrderItemDto = orderItemService.createOrderItem(orderItemDto);
        return new ResponseEntity<>(createdOrderItemDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDto> updateOrderItem(@PathVariable Long id, @RequestBody OrderItemDto orderItemDto) {
        orderItemDto.setId(id);
        OrderItemDto updatedOrderItemDto = orderItemService.updateOrderItem(orderItemDto);
        return new ResponseEntity<>(updatedOrderItemDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItemDto>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        List<OrderItemDto> orderItemDtos = orderItemService.getOrderItemsByOrderId(orderId);
        return new ResponseEntity<>(orderItemDtos, HttpStatus.OK);
    }
}