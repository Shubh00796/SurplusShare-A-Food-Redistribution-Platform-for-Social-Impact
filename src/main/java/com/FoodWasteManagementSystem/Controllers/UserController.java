package com.FoodWasteManagementSystem.Controllers;

// UserController.java (Updated)

import com.FoodWasteManagementSystem.Configs.JwtTokenGenerator;
import com.FoodWasteManagementSystem.DTOs.LoginRequest;
import com.FoodWasteManagementSystem.DTOs.UserDto;
import com.FoodWasteManagementSystem.Enums.Role;
import com.FoodWasteManagementSystem.Service.UserServiceInterface;
import com.FoodWasteManagementSystem.ServiceImpl.RoleBasedAccessControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceInterface userService;
    private final RoleBasedAccessControlService roleBasedAccessControlService;
    private final JwtTokenGenerator jwtTokenGenerator;


    // **Admin Only (Using hasHigherRoleThan)**
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(@AuthenticationPrincipal UserDto userDto) {
        if (roleBasedAccessControlService.hasHigherRoleThan(userDto, Role.ROLE_ADMIN)) {
            List<UserDto> users = userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody UserDto userDto) {
        UserDto registeredUser = userService.registerUser(userDto);
        String token = jwtTokenGenerator.generateToken(registeredUser);
        Map<String, Object> response = new HashMap<>();
        response.put("user", registeredUser);
        response.put("token", token);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // **Authenticated User (any role) can access their own profile**
    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser(@AuthenticationPrincipal UserDto userDto) {
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    // **Role-Based Access: Only Users with ROLE_OFFICER or above can create new Users (Using hasAnyRole)**
    @PostMapping
    public ResponseEntity<UserDto> createUser(@AuthenticationPrincipal UserDto userDto, @RequestBody UserDto newUserDto) {
        List<Role> allowedRoles = List.of(Role.ROLE_OFFICER, Role.ROLE_CREW_MANAGER, Role.ROLE_ADMIN);
        if (roleBasedAccessControlService.hasAnyRole(userDto, allowedRoles)) {
            UserDto createdUser = userService.registerUser(newUserDto);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    // **Role-Based Access: Only Users with ROLE_ADMIN can update/delete Users (Using hasHigherRoleThan)**
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@AuthenticationPrincipal UserDto userDto, @PathVariable Long id, @RequestBody UserDto updatedUserDto) {
        if (roleBasedAccessControlService.hasHigherRoleThan(userDto, Role.ROLE_ADMIN)) {
            UserDto updatedUser = userService.updateUser(updatedUserDto);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username, @AuthenticationPrincipal UserDto userDto) {
        if (roleBasedAccessControlService.hasHigherRoleThan(userDto, Role.ROLE_ADMIN)) {
            UserDto user = userService.getUserByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email, @AuthenticationPrincipal UserDto userDto) {
        if (roleBasedAccessControlService.hasHigherRoleThan(userDto, Role.ROLE_ADMIN)) {
            UserDto user = userService.getUserByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@AuthenticationPrincipal UserDto userDto, @PathVariable Long id) {
        if (roleBasedAccessControlService.hasHigherRoleThan(userDto, Role.ROLE_ADMIN)) {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            UserDto user = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
            String token = userService.generateTokenForUser(user);
            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("token", token);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

}