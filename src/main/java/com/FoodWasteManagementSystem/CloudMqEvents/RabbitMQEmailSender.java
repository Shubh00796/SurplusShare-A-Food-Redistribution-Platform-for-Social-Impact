package com.FoodWasteManagementSystem.CloudMqEvents;

import com.FoodWasteManagementSystem.DTOs.Email;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQEmailSender {
    private final JavaMailSender javaMailSender;
    private final CloudAMQPProperties cloudAMQPProperties;

    @Autowired
    public RabbitMQEmailSender(JavaMailSender javaMailSender, CloudAMQPProperties cloudAMQPProperties) {
        this.javaMailSender = javaMailSender;
        this.cloudAMQPProperties = cloudAMQPProperties;
    }

    @RabbitListener(queues = "#{cloudAMQPProperties.getQueueName()}")
    public void receiveEmail(Email email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email.getTo());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getText());
        javaMailSender.send(mailMessage);
    }
}