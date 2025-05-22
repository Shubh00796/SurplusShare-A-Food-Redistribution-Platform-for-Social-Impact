package com.FoodWasteManagementSystem.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "food_waste_item_collection_centers")
@AllArgsConstructor
@NoArgsConstructor
public class FoodWasteItemCollectionCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long foodWasteItemId;
    private Long collectionCenterId;
}