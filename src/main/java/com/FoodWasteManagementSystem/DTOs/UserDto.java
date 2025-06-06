package com.FoodWasteManagementSystem.DTOs;

import com.FoodWasteManagementSystem.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String address;
    private String passwordResetToken;
    private Instant passwordResetTokenExpiration;
    private Role role;
}