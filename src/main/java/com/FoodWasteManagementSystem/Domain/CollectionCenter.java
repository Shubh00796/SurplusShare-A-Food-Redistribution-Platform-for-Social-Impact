package com.FoodWasteManagementSystem.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "collection_centers")
public class CollectionCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private Double maxCapacity;
}