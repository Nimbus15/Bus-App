package com.belfastdev.dto;

import com.belfastdev.model.BusJourney;

public class JourneyResponse {
    private String routeId;
    private String startStopId;
    private String endStopId;

    public static JourneyResponse from(BusJourney journey) {
        JourneyResponse response = new JourneyResponse();
        response.routeId = journey.getRouteId();
        response.startStopId = journey.getStartStopId();
        response.endStopId = journey.getEndStopId();
        return response;
    }

    public String getRouteId() { return routeId; }
    public String getStartStopId() { return startStopId; }
    public String getEndStopId() { return endStopId; }
}
