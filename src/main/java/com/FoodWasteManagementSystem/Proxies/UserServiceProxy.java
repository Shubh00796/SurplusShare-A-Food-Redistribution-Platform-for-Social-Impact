package com.FoodWasteManagementSystem.Proxies;

import com.FoodWasteManagementSystem.DTOs.UserDto;
import com.FoodWasteManagementSystem.Service.UserServiceInterface;

import java.util.List;

public class UserServiceProxy implements UserServiceInterface {
    private final UserServiceInterface userService;

    public UserServiceProxy(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        return userService.registerUser(userDto);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public UserDto getUserById(Long id) {
        return userService.getUserById(id);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);


    }

    @Override
    public String generatePasswordResetToken(String email) {
        return userService.generatePasswordResetToken(email);
    }

    @Override
    public UserDto authenticateUser(String username, String rawPassword) {
        return userService.authenticateUser(username, rawPassword);
    }

    @Override
    public String generateTokenForUser(UserDto user) {
        return userService.generateTokenForUser(user);
    }
}
