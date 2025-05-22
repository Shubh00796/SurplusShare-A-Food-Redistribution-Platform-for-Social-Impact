package com.FoodWasteManagementSystem.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "food_waste_items")
@AllArgsConstructor
@RequiredArgsConstructor
public class FoodWasteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double weight;
    private LocalDate expirationDate;
    private String type;
    private Long foodDonorId;
}