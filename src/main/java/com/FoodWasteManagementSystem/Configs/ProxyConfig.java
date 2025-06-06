package com.FoodWasteManagementSystem.Configs;

import com.FoodWasteManagementSystem.Proxies.UserServiceProxy;
import com.FoodWasteManagementSystem.Service.UserServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyConfig {
    @Bean
    public UserServiceProxy userServiceProxy(UserServiceInterface userService) {
        return new UserServiceProxy(userService);
    }
}