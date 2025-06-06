package com.FoodWasteManagementSystem.Controllers;

import com.FoodWasteManagementSystem.DTOs.PasswordResetRequest;
import com.FoodWasteManagementSystem.Exceptions.InvalidEmailException;
import com.FoodWasteManagementSystem.Exceptions.UserNotFoundException;
import com.FoodWasteManagementSystem.Service.ForgotPasswordUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class ForgotPasswordController {

    private final ForgotPasswordUseCase forgotPasswordUseCase;

    public ForgotPasswordController(ForgotPasswordUseCase forgotPasswordUseCase) {
        this.forgotPasswordUseCase = forgotPasswordUseCase;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<HttpStatus> forgotPassword(@RequestBody PasswordResetRequest request) {
        try {
            forgotPasswordUseCase.execute(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InvalidEmailException e) {
            log.warn("Invalid email address provided for password reset", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (UserNotFoundException e) {
            log.warn("User not found for email address: {}", request.getEmail(), e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}