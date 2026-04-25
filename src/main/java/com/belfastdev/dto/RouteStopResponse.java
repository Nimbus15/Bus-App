package com.belfastdev.dto;

import com.belfastdev.model.BusRouteStop;

public class RouteStopResponse {
    private String id;
    private String name;

    public static RouteStopResponse from(BusRouteStop stop) {
        RouteStopResponse response = new RouteStopResponse();
        response.id = stop.getId();
        response.name = stop.getName();
        return response;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}
