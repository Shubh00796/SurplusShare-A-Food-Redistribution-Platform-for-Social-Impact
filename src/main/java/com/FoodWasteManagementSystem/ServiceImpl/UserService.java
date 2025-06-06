package com.FoodWasteManagementSystem.ServiceImpl;


import com.FoodWasteManagementSystem.Configs.JwtTokenGenerator;
import com.FoodWasteManagementSystem.DTOs.UserDto;
import com.FoodWasteManagementSystem.Domain.User;
import com.FoodWasteManagementSystem.Exceptions.ResourceNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.UserMapper;
import com.FoodWasteManagementSystem.ReposiotryServices.UserRepositoryService;
import com.FoodWasteManagementSystem.Service.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepositoryService userRepositoryService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtTokenGenerator jwtTokenGenerator;

    @Override
    @Transactional
    public UserDto registerUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepositoryService.createUser(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    @Transactional
    public UserDto updateUser(UserDto userDto) {
        User user = getUserByIdOrThrow(userDto.getId());
        userMapper.updateEntityFromDto(userDto, user);
        User savedUser = userRepositoryService.createUser(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    @Transactional
    public List<UserDto> getAllUsers() {
        return userRepositoryService.getAllUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public UserDto getUserById(Long id) {
        return userMapper.toDto(getUserByIdOrThrow(id));
    }

    @Override
    @Transactional
    public UserDto getUserByUsername(String username) {
        User user = userRepositoryService.getUserByUsername(username);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public UserDto getUserByEmail(String email) {
        User user = userRepositoryService.getUserByEmail(email);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepositoryService.deleteUser(id);
    }

    @Override
    @Transactional
    public String generatePasswordResetToken(String email) {
        UserDto user = validatePasswordReset(email);

        String token = generateToken();
        user.setPasswordResetToken(token);
        user.setPasswordResetTokenExpiration(calculateExpiration(30, ChronoUnit.MINUTES));

        userRepositoryService.updateUser(userMapper.toEntity(user));

        return token;
    }

    @Override
    @Transactional
    public UserDto authenticateUser(String username, String rawPassword) {
        UserDto user = getUserByUsername(username);
        validateUsernameAndPassword(rawPassword, user);
        return user;
    }

    @Override
    public String generateTokenForUser(UserDto user) {
        return jwtTokenGenerator.generateToken(user);
    }

    // --- Private Helper Methods ---

    private User getUserByIdOrThrow(Long id) {
        return userRepositoryService.getUserById(id);
    }

    private void validateUsernameAndPassword(String rawPassword, UserDto user) {
        if (user == null ||!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    private UserDto validatePasswordReset(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        UserDto user = getUserByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with email: " + email);
        }

        return user;
    }

    private String generateToken() {
        return java.util.UUID.randomUUID().toString();
    }

    private Instant calculateExpiration(long duration, ChronoUnit unit) {
        return Instant.now().plus(duration, unit);
    }
}