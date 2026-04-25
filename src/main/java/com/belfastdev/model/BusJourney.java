package com.belfastdev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusJourney {
    private String routeId;
    private String startStopId;
    private String endStopId;

    public BusJourney() {}

    public BusJourney(String routeId, String startStopId, String endStopId) {
        this.routeId = routeId;
        this.startStopId = startStopId;
        this.endStopId = endStopId;
    }

    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }

    public String getStartStopId() { return startStopId; }
    public void setStartStopId(String startStopId) { this.startStopId = startStopId; }

    public String getEndStopId() { return endStopId; }
    public void setEndStopId(String endStopId) { this.endStopId = endStopId; }
}
