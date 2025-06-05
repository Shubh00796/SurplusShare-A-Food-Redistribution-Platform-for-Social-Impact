package com.FoodWasteManagementSystem.Domain;

import com.FoodWasteManagementSystem.Enums.Role;
import jakarta.persistence.*;
import lombok.*;

// User.java
@Entity
@Table(name = "users_for_issue")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String address;
    @Enumerated(EnumType.STRING)
    private Role role;
}

