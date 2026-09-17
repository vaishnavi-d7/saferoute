package com.example.saferoute.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenRouteService {

    @Value("${openrouteservice.api.key:default_key}")
    private String apiKey;

    public String getRouteCoordinates(String start, String end) {
        String url = "https://api.openrouteservice.org/v2/directions/driving-car?api_key=" 
                     + apiKey + "&start=" + start + "&end=" + end;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}