package com.example.MyGreetingApp.controller;

import com.example.MyGreetingApp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        boolean isDeleted = greetingService.deleteGreeting(id);
        if (isDeleted) {
            return "Greeting with ID " + id + " deleted successfully.";
        } else {
            return "Greeting with ID " + id + " not found.";
        }
    }
}