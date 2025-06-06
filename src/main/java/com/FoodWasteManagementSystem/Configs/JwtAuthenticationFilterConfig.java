package com.FoodWasteManagementSystem.Configs;

import com.FoodWasteManagementSystem.Proxies.UserServiceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class JwtAuthenticationFilterConfig {

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(
            @Lazy UserServiceProxy userServiceProxy,
            JwtTokenVerifier jwtTokenVerifier) {
        return new JwtAuthenticationFilter(userServiceProxy, jwtTokenVerifier);
    }

}