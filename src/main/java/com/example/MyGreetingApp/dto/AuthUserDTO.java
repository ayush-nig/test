package com.example.MyGreetingApp.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserDTO {

    @NotBlank
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "First name must start with an uppercase letter")
    private String firstName;

    @NotBlank
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Last name must start with an uppercase letter")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[@#$%^&+=])(?=.*[0-9]).*$",
            message = "Password must have 1 uppercase letter, 1 special character, and 1 number")
    private String password;
}
