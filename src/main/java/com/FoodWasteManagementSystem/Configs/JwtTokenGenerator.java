package com.FoodWasteManagementSystem.Configs;

import com.FoodWasteManagementSystem.DTOs.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenGenerator {
    private final SecretKey secret;
    private final Long expiration;

    public JwtTokenGenerator(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") Long expiration) {
        this.secret = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expiration = expiration;
    }

    public String generateToken(UserDto userDto) {
        return Jwts.builder()
                .setSubject(userDto.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .claim("userRole", userDto.getRole().name())
                .signWith(secret, SignatureAlgorithm.HS512)
                .compact();
    }
}