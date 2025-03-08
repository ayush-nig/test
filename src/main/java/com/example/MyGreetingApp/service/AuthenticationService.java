package com.example.MyGreetingApp.service;

import com.example.MyGreetingApp.dto.AuthUserDTO;
import com.example.MyGreetingApp.model.AuthUser;
import com.example.MyGreetingApp.repository.AuthUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthUserRepository authUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String registerUser(AuthUserDTO authUserDTO) {
        if (authUserRepository.existsByEmail(authUserDTO.getEmail())) {
            return "Email is already in use.";
        }

        AuthUser newUser = new AuthUser();
        newUser.setFirstName(authUserDTO.getFirstName());
        newUser.setLastName(authUserDTO.getLastName());
        newUser.setEmail(authUserDTO.getEmail());
        newUser.setPassword(passwordEncoder.encode(authUserDTO.getPassword()));

        authUserRepository.save(newUser);
        return "User registered successfully!";
    }
}
