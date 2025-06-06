package com.FoodWasteManagementSystem.ServiceImpl;

import com.FoodWasteManagementSystem.DTOs.Email;
import com.FoodWasteManagementSystem.Service.EmailSenderPort;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderAdapter implements EmailSenderPort {
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public EmailSenderAdapter(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void sendEmail(Email email) {
        amqpTemplate.convertAndSend("email_queue", email);
    }

}