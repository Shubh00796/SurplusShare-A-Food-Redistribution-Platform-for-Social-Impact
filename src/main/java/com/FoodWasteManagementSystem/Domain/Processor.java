package com.FoodWasteManagementSystem.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "processors")
public class Processor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Double maxProcessingCapacity;
}