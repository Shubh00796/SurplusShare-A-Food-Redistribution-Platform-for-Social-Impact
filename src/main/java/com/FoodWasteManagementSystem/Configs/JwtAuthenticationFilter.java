package com.FoodWasteManagementSystem.Configs;

import com.FoodWasteManagementSystem.DTOs.UserDto;
import com.FoodWasteManagementSystem.Domain.User;
import com.FoodWasteManagementSystem.Enums.Role;
import com.FoodWasteManagementSystem.Proxies.UserServiceProxy;
import com.FoodWasteManagementSystem.Service.UserServiceInterface;
import com.FoodWasteManagementSystem.ServiceImpl.UserService;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final @Lazy UserServiceProxy userService;
    private final JwtTokenVerifier jwtTokenVerifier;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null && jwtTokenVerifier.verifyToken(token)) {
            String username = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody().getSubject();
            UserDto userDto = userService.getUserByUsername(username);
            User user = User.builder()
                    .username(userDto.getUsername())
                    .email(userDto.getEmail())
                    .fullName(userDto.getFullName())
                    .address(userDto.getAddress())
                    .role(userDto.getRole())
                    .build();
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null, getAuthorities(userDto.getRole())));
        }
        filterChain.doFilter(request, response);
    }

    private List<org.springframework.security.core.GrantedAuthority> getAuthorities(Role role) {
        List<org.springframework.security.core.GrantedAuthority> authorities = new ArrayList<>();
        switch (role) {
            case ROLE_CITIZEN:
                authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_CITIZEN"));
                break;
            case ROLE_OFFICER:
                authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_OFFICER"));
                break;
            case ROLE_CREW_MANAGER:
                authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_CREW_MANAGER"));
                break;
            case ROLE_TECHNICIAN:
                authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_TECHNICIAN"));
                break;
            case ROLE_ADMIN:
                authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_ADMIN"));
                break;
        }
        return authorities;
    }
}