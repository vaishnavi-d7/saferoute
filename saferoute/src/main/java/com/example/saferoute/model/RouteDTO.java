package com.example.saferoute.model;

public class RouteDTO {
    private String routeName;
    private double distanceKm;
    private double durationMin;
    private int safetyScore;

    public RouteDTO() {}

    public RouteDTO(String routeName, double distanceKm, double durationMin, int safetyScore) {
        this.routeName = routeName;
        this.distanceKm = distanceKm;
        this.durationMin = durationMin;
        this.safetyScore = safetyScore;
    }

    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }

    public double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(double distanceKm) { this.distanceKm = distanceKm; }

    public double getDurationMin() { return durationMin; }
    public void setDurationMin(double durationMin) { this.durationMin = durationMin; }

    public int getSafetyScore() { return safetyScore; }
    public void setSafetyScore(int safetyScore) { this.safetyScore = safetyScore; }
}