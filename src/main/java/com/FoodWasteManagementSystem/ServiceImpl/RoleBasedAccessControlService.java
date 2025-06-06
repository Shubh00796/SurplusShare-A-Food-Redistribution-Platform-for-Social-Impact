package com.FoodWasteManagementSystem.ServiceImpl;

// RoleBasedAccessControlService.java

import com.FoodWasteManagementSystem.DTOs.UserDto;
import com.FoodWasteManagementSystem.Enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.FoodWasteManagementSystem.Enums.Role.*;

@Service
public class RoleBasedAccessControlService {

    public boolean hasRole(UserDto userDto, Role role) {
        return userDto.getRole().equals(role);
    }

    public boolean hasAnyRole(UserDto userDto, List<Role> roles) {
        return roles.contains(userDto.getRole());
    }

    public boolean hasHigherRoleThan(UserDto userDto, Role baseRole) {
        return getRoleHierarchy().get(baseRole) != null && getRoleHierarchy().get(baseRole) <= getRoleHierarchy().get(userDto.getRole());
    }

    private List<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toList());
    }

    private int getRoleHierarchy(Role role) {
        switch (role) {
            case ROLE_ADMIN:
                return 5;
            case ROLE_CREW_MANAGER:
                return 4;
            case ROLE_OFFICER:
                return 3;
            case ROLE_TECHNICIAN:
                return 2;
            case ROLE_CITIZEN:
                return 1;
            default:
                return 0;
        }
    }

    private Map<Role, Integer> getRoleHierarchy() {
        return Map.of(
                ROLE_ADMIN, 5,
                ROLE_CREW_MANAGER, 4,
                ROLE_OFFICER, 3,
                ROLE_TECHNICIAN, 2,
                ROLE_CITIZEN, 1
        );
    }
}