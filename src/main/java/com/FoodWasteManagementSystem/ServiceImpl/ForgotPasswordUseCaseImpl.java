package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.PasswordResetRequest;
import com.FoodWasteManagementSystem.DTOs.UserDto;
import com.FoodWasteManagementSystem.Domain.User;
import com.FoodWasteManagementSystem.Exceptions.InvalidEmailException;
import com.FoodWasteManagementSystem.Exceptions.UserNotFoundException;
import com.FoodWasteManagementSystem.MapstructMappers.UserMapper;
import com.FoodWasteManagementSystem.Service.EmailValidator;
import com.FoodWasteManagementSystem.Service.ForgotPasswordUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ForgotPasswordUseCaseImpl implements ForgotPasswordUseCase {

    private final EmailValidator emailValidator;
    private final UserService userService;
    private final EmailService emailService;
    private final UserMapper mapper;


    @Override
    public void execute(PasswordResetRequest request) throws InvalidEmailException, UserNotFoundException {
        String email = request.getEmail();
        if (!emailValidator.isValid(email)) {
            throw new InvalidEmailException("Invalid email address");
        }

        String token = userService.generatePasswordResetToken(email);
        if (token == null) {
            throw new UserNotFoundException("User not found for email address: " + email);
        }

        UserDto user = userService.getUserByEmail(email);
        User entity = mapper.toEntity(user);
        emailService.sendForgotPasswordEmail(entity, token);
    }


}