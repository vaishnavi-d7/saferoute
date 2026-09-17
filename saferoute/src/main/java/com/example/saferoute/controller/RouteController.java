package com.example.saferoute.controller;

import com.example.saferoute.service.OpenRouteService;
import com.example.saferoute.service.SafetyCalculatorService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final OpenRouteService openRouteService;
    private final SafetyCalculatorService safetyCalculatorService;

    // Spring automatically wires constructor parameters without needing @Autowired
    public RouteController(OpenRouteService openRouteService, SafetyCalculatorService safetyCalculatorService) {
        this.openRouteService = openRouteService;
        this.safetyCalculatorService = safetyCalculatorService;
    }

    @GetMapping("/safe-path")
    public Map<String, Object> getSafePath(
            @RequestParam String start,
            @RequestParam String end,
            @RequestParam(defaultValue = "12.9716") double lat,
            @RequestParam(defaultValue = "77.5946") double lng) {

        String geoJsonData = openRouteService.getRouteCoordinates(start, end);
        int score = safetyCalculatorService.calculateSafetyScore(lat, lng);

        Map<String, Object> response = new HashMap<>();
        response.put("geoJson", geoJsonData);
        response.put("safetyScore", score);

        return response;
    }
}