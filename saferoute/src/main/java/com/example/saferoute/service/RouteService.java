package com.example.saferoute.service;

import com.example.saferoute.model.Incident;
import com.example.saferoute.repository.IncidentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RouteService {

    private final IncidentRepository incidentRepository;

    public RouteService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    // Calculate Safety Score based on nearby incidents
    public double calculateSafetyScore(List<double[]> pathCoordinates) {
        // Fix 1: Retrieve all incidents from database
        List<Incident> incidents = incidentRepository.findAll();
        int totalRiskPoints = 0;

        for (double[] point : pathCoordinates) {
            double lat = point[0];
            double lng = point[1];

            for (Incident incident : incidents) {
                double distance = haversineDistance(lat, lng, incident.getLatitude(), incident.getLongitude());
                
                // If incident is within 500 meters (0.5 km) radius
                if (distance < 0.5) {
                    // Fix 2: Safely convert severity to integer weight
                    int severityWeight = getSeverityWeight(incident.getSeverity());
                    totalRiskPoints += severityWeight * 10;
                }
            }
        }

        // Deduct risk from base score of 100
        double finalScore = 100 - totalRiskPoints;
        return Math.max(finalScore, 10.0); // Minimum safety floor
    }

    // Convert Severity String/Int to numerical weight safely
    private int getSeverityWeight(Object severity) {
        if (severity == null) return 1;
        
        String sevStr = String.valueOf(severity).toUpperCase();
        switch (sevStr) {
            case "HIGH":
            case "3":
                return 3;
            case "MEDIUM":
            case "2":
                return 2;
            case "LOW":
            case "1":
            default:
                return 1;
        }
    }

    // Haversine formula for distance calculation in KM
    private double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371; // Earth radius in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}