package com.example.saferoute.controller;

import com.example.saferoute.model.Incident;
import com.example.saferoute.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin(origins = "*")
public class IncidentController {

    @Autowired
    private IncidentRepository incidentRepository;

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }
}