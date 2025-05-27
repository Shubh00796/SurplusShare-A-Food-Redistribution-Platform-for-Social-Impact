package com.FoodWasteManagementSystem.Domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "materials")
public class MaterialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(columnDefinition = "DECIMAL(10, 2)")
    private BigDecimal quantity;
    @Column(columnDefinition = "DECIMAL(10, 2)")
    private BigDecimal weight;
}