package com.FoodWasteManagementSystem.CloudMqEvents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {
    private final CloudAMQPProperties cloudAMQPProperties;

    public RabbitMQConfig(CloudAMQPProperties cloudAMQPProperties) {
        this.cloudAMQPProperties = cloudAMQPProperties;
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(cloudAMQPProperties.getQueueName(), true);
    }
}