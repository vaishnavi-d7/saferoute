package com.example.saferoute.model;

import java.util.List;

public class RouteDTO {
    private List<double[]> coordinates;
    private double distanceKm;
    private double estimatedTimeMins;
    private double safetyScore; // 0 to 100
    private String routeType;   // "SAFEST" or "FASTEST"

    public RouteDTO() {}

    public RouteDTO(List<double[]> coordinates, double distanceKm, double estimatedTimeMins, double safetyScore, String routeType) {
        this.coordinates = coordinates;
        this.distanceKm = distanceKm;
        this.estimatedTimeMins = estimatedTimeMins;
        this.safetyScore = safetyScore;
        this.routeType = routeType;
    }

    // Getters and Setters
    public List<double[]> getCoordinates() { return coordinates; }
    public void setCoordinates(List<double[]> coordinates) { this.coordinates = coordinates; }

    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) { this.distanceKm = distanceKm; }

    public double getEstimatedTimeMins() { return estimatedTimeMins; }
    public void setEstimatedTimeMins(double estimatedTimeMins) { this.estimatedTimeMins = estimatedTimeMins; }

    public double getSafetyScore() { return safetyScore; }
    public void setSafetyScore(double safetyScore) { this.safetyScore = safetyScore; }

    public String getRouteType() { return routeType; }
    public void setRouteType(String routeType) { this.routeType = routeType; }
}