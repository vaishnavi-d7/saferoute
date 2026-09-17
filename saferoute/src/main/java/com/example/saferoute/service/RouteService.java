package com.example.saferoute.service;

import com.example.saferoute.model.RouteDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RouteService {

    @Value("${openrouteservice.api.key:dummy_key}")
    private String apiKey;

    private final SafetyCalculatorService safetyCalculatorService;
    private final RestTemplate restTemplate = new RestTemplate();

    public RouteService(SafetyCalculatorService safetyCalculatorService) {
        this.safetyCalculatorService = safetyCalculatorService;
    }

    @SuppressWarnings("unchecked")
    public List<RouteDTO> getRealRoutes(String start, String end) {
        try {
            String url = String.format(
                "https://api.openrouteservice.org/v2/directions/driving-car?api_key=%s&start=%s&end=%s",
                apiKey, start, end
            );

            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            if (response == null || !response.containsKey("features")) {
                return getFallbackRoutes();
            }

            List<Map<String, Object>> features = (List<Map<String, Object>>) response.get("features");
            List<RouteDTO> routeList = new ArrayList<>();

            for (int i = 0; i < features.size(); i++) {
                Map<String, Object> properties = (Map<String, Object>) features.get(i).get("properties");
                Map<String, Object> summary = (Map<String, Object>) properties.get("summary");

                double distanceMeters = ((Number) summary.get("distance")).doubleValue();
                double durationSeconds = ((Number) summary.get("duration")).doubleValue();

                double distanceKm = Math.round((distanceMeters / 1000.0) * 10.0) / 10.0;
                double durationMin = Math.round((durationSeconds / 60.0) * 10.0) / 10.0;

                // Dynamic safety score from our DB algorithm
                int calculatedScore = safetyCalculatorService.calculateSafetyScore(distanceKm, durationMin) - (i * 10);
                int finalScore = Math.max(0, Math.min(100, calculatedScore));

                String routeLabel = (i == 0) ? "Route A (Recommended)" : "Route " + (char)('A' + i) + " (Alternative)";
                routeList.add(new RouteDTO(routeLabel, distanceKm, durationMin, finalScore));
            }

            return routeList.isEmpty() ? getFallbackRoutes() : routeList;

        } catch (Exception e) {
            System.err.println("Map API Call Error: " + e.getMessage() + ". Using fallback routes.");
            return getFallbackRoutes();
        }
    }

    private List<RouteDTO> getFallbackRoutes() {
        int score = safetyCalculatorService.calculateSafetyScore(2.4, 5.4);
        return List.of(
            new RouteDTO("Route A (Recommended)", 2.4, 5.4, score),
            new RouteDTO("Route B (Alternative)", 3.1, 7.0, Math.max(0, score - 15))
        );
    }
}