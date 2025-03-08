package com.example.MyGreetingApp.controller;

import com.example.MyGreetingApp.dto.AuthUserDTO;
import com.example.MyGreetingApp.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    private final AuthenticationService authenticationService;

    public AuthUserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody AuthUserDTO authUserDTO) {
        String response = authenticationService.registerUser(authUserDTO);
        return ResponseEntity.ok(response);
    }
}
