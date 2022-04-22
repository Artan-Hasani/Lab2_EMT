package com.example.lab2_backend.model.dto;

import com.example.lab2_backend.model.User;
import com.example.lab2_backend.model.enumeration.Role;
import lombok.Data;


@Data
public class UserDetailsDto {
    private String username;
    private Role role;

    public static UserDetailsDto of(User user) {
        UserDetailsDto details = new UserDetailsDto();
        details.username = user.getUsername();
        details.role = user.getRole();
        return details;
    }
}
