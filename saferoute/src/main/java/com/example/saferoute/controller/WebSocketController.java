package com.example.saferoute.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebSocketController {

    @MessageMapping("/report-incident")
    @SendTo("/topic/alerts")
    public Map<String, Object> handleReportIncident(Map<String, Object> payload) {
        System.out.println("Received Hazard Incident Payload: " + payload);

        Map<String, Object> response = new HashMap<>();
        response.put("id", System.currentTimeMillis());
        response.put("type", payload.getOrDefault("type", "Road Risk"));
        response.put("severity", payload.getOrDefault("severity", "5"));
        
        // Frontend marker map-ku exact-a venundiyadhu:
        response.put("latitude", payload.getOrDefault("latitude", 12.9709));
        response.put("longitude", payload.getOrDefault("longitude", 77.6003));

        return response;
    }
}