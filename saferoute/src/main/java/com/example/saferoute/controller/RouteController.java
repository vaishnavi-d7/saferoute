package com.example.saferoute.controller;

import com.example.saferoute.model.RouteDTO;
import com.example.saferoute.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "*")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/find")
    public List<RouteDTO> getRoutes(@RequestParam double startLat, @RequestParam double startLng,
                                   @RequestParam double endLat, @RequestParam double endLng) {

        // Dummy coordinate arrays representing 2 alternative paths for testing
        List<double[]> fastestPath = Arrays.asList(
            new double[]{startLat, startLng},
            new double[]{(startLat + endLat) / 2, (startLng + endLng) / 2},
            new double[]{endLat, endLng}
        );

        List<double[]> safestPath = Arrays.asList(
            new double[]{startLat, startLng},
            new double[]{(startLat + endLat) / 2 + 0.005, (startLng + endLng) / 2 + 0.005},
            new double[]{endLat, endLng}
        );

        double fastestScore = routeService.calculateSafetyScore(fastestPath);
        double safestScore = routeService.calculateSafetyScore(safestPath) + 15; // Adjusted detour score

        RouteDTO fastest = new RouteDTO(fastestPath, 5.2, 12.0, Math.min(fastestScore, 100), "FASTEST");
        RouteDTO safest = new RouteDTO(safestPath, 6.1, 15.0, Math.min(safestScore, 98.0), "SAFEST");

        return Arrays.asList(fastest, safest);
    }
}