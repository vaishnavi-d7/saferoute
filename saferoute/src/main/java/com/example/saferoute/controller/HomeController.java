package com.example.saferoute.controller;

import com.example.saferoute.model.Location;
import com.example.saferoute.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/")
    public String home() {
        return "Welcome to SafeRoute! 🛡️ Your safety-first route recommender is running.";
    }

    // CREATE - Add a new location
    @PostMapping("/locations")
    public Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    // READ - Get all locations
    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // READ - Get one location by ID
    @GetMapping("/locations/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id " + id));
    }

    // UPDATE - Update an existing location
    @PutMapping("/locations/{id}")
    public Location updateLocation(@PathVariable Long id, @RequestBody Location updatedLocation) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id " + id));

        location.setName(updatedLocation.getName());
        location.setLatitude(updatedLocation.getLatitude());
        location.setLongitude(updatedLocation.getLongitude());

        return locationRepository.save(location);
    }

    // DELETE - Delete a location
    @DeleteMapping("/locations/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationRepository.deleteById(id);
        return "Location with id " + id + " deleted successfully.";
    }
}