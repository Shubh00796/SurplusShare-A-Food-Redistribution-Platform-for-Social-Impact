package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.UserDto;

import java.util.List;

public interface UserServiceInterface {

    UserDto registerUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto getUserByUsername(String username);

    UserDto getUserByEmail(String email);

    void deleteUser(Long id);

    String generatePasswordResetToken(String email);


    UserDto authenticateUser(String username, String rawPassword);


    String generateTokenForUser(UserDto user);


}