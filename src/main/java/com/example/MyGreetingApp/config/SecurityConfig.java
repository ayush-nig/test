package com.example.MyGreetingApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()  // Allow H2 Console access
                        .requestMatchers("/auth/register", "/auth/login").permitAll()  // Allow Register & Login
                        .anyRequest().authenticated()  // Protect other endpoints
                )
                .csrf(csrf -> csrf.disable())  // Disable CSRF for testing
                .headers(headers -> headers.frameOptions(frame -> frame.disable())); // Enable H2 Console frames

        return http.build();
    }
}
