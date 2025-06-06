package com.FoodWasteManagementSystem.Service;

import com.FoodWasteManagementSystem.DTOs.Email;

public interface EmailSenderPort {
 void sendEmail(Email email);

}