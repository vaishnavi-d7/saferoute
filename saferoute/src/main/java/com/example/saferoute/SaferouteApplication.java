package com.example.saferoute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.saferoute")
public class SaferouteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaferouteApplication.class, args);
    }
}