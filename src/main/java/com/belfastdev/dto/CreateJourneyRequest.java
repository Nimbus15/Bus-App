package com.belfastdev.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateJourneyRequest {

    @NotBlank(message = "Route ID is required")
    private String routeId;

    @NotBlank(message = "Start stop ID is required")
    private String startStopId;

    @NotBlank(message = "End stop ID is required")
    private String endStopId;

    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }

    public String getStartStopId() { return startStopId; }
    public void setStartStopId(String startStopId) { this.startStopId = startStopId; }

    public String getEndStopId() { return endStopId; }
    public void setEndStopId(String endStopId) { this.endStopId = endStopId; }
}
