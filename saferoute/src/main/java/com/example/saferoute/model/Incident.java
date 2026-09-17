package com.example.saferoute.model;

import jakarta.persistence.*;

@Entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;        // e.g. "Poor Lighting", "Accident", "Theft"
    private String severity;    // e.g. "Low", "Medium", "High"

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}