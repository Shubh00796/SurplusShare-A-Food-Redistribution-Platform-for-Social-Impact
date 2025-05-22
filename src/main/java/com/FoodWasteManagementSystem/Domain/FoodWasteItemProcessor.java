package com.FoodWasteManagementSystem.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "food_waste_item_processors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodWasteItemProcessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long foodWasteItemId;
    private Long processorId;
}