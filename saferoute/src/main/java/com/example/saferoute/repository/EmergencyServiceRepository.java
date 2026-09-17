package com.example.saferoute.repository;

import com.example.saferoute.model.EmergencyService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyServiceRepository extends JpaRepository<EmergencyService, Long> {
}