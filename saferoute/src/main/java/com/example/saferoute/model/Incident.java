package com.example.saferoute.model;

import jakarta.persistence.*;

@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double latitude;
    private double longitude;
    private String severity; // e.g., "HIGH", "MEDIUM", "LOW"

    public Incident() {}

    public Incident(String description, double latitude, double longitude, String severity) {
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.severity = severity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
}