package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.Email;
import com.FoodWasteManagementSystem.Domain.User;
import com.FoodWasteManagementSystem.Service.EmailSenderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailSenderPort emailSenderPort;
    @Value("${server.base-url}")
    private String serverBaseUrl;
    @Value("${reset.password.url}")
    private String resetPasswordUrl;

    public void sendForgotPasswordEmail(User user, String token) {
        String subject = "Password Reset Request";
        String resetLink = serverBaseUrl + resetPasswordUrl + "?token=" + token;
        String body = String.format("Hi %s,\n\n" + "We received a request to reset your password.\n\n" + "Click the link below to reset your password:\n%s\n\n" + "This link will expire in 30 minutes.\n\n" + "If you did not request a password reset, please ignore this email.\n\n" + "Best regards,\nFood Waste Management Team", user.getFullName(), resetLink);

        Email email = new Email(user.getEmail(), subject, body);

        emailSenderPort.sendEmail(email);
    }
}