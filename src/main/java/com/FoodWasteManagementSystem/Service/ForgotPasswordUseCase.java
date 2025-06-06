package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.PasswordResetRequest;
import com.FoodWasteManagementSystem.Exceptions.InvalidEmailException;
import com.FoodWasteManagementSystem.Exceptions.UserNotFoundException;

public interface ForgotPasswordUseCase {
    void execute(PasswordResetRequest request) throws InvalidEmailException, UserNotFoundException;
}