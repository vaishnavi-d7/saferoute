package com.example.saferoute.service;

import com.example.saferoute.repository.EmergencyServiceRepository;
import com.example.saferoute.repository.IncidentRepository;
import org.springframework.stereotype.Service;

@Service
public class SafetyCalculatorService {

    private final IncidentRepository incidentRepository;
    private final EmergencyServiceRepository emergencyServiceRepository;

    public SafetyCalculatorService(IncidentRepository incidentRepository, 
                                   EmergencyServiceRepository emergencyServiceRepository) {
        this.incidentRepository = incidentRepository;
        this.emergencyServiceRepository = emergencyServiceRepository;
    }

    public int calculateSafetyScore(double distanceKm, double durationMin) {
        int baseScore = 100;

        // Fetch total incidents and emergency services from DB
        long incidentCount = incidentRepository.count();
        long emergencyCount = emergencyServiceRepository.count();

        // Safety Formula: Reduce for incidents, boost for emergency support
        int incidentDeduction = (int) (incidentCount * 5);
        int emergencyBonus = (int) (emergencyCount * 3);

        int finalScore = baseScore - incidentDeduction + emergencyBonus;

        // Clamp score between 0 and 100
        return Math.min(100, Math.max(0, finalScore));
    }
}