package com.FoodWasteManagementSystem.Configs;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenVerifier {
    private final String secret;

    public JwtTokenVerifier(String secret) {
        this.secret = secret;
    }

    public boolean verifyToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}