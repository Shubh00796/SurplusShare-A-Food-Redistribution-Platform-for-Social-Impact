package com.FoodWasteManagementSystem.Configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    @Bean
    public JwtTokenGenerator jwtTokenGenerator() {
        return new JwtTokenGenerator(secret, expiration);
    }

    @Bean
    public JwtTokenVerifier jwtTokenVerifier() {
        return new JwtTokenVerifier(secret);
    }
}