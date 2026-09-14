package com.example.saferoute.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to SafeRoute! 🛡️ Your safety-first route recommender is running.";
    }
}