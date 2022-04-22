package com.example.lab2_backend.service.Int;


import com.example.lab2_backend.model.User;
import com.example.lab2_backend.model.enumeration.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}
