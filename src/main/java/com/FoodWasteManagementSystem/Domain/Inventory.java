package com.FoodWasteManagementSystem.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String skuCode;
    private Integer quantity;
    private LocalDate dueDate;
    private LocalDate lastUpdatedDate;
    private String inventoryStatus;
}