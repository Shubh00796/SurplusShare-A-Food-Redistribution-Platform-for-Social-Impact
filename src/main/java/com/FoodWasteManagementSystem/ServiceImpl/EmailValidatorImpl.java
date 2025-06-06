package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.Service.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailValidatorImpl implements EmailValidator {

    @Override
    public boolean isValid(String email) {
        return email != null && !email.isEmpty() && email.contains("@");
    }
}