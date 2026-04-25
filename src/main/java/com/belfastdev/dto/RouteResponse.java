package com.belfastdev.dto;

import com.belfastdev.model.BusRoute;

public class RouteResponse {
    private String id;
    private String name;
    private String direction;

    public static RouteResponse from(BusRoute route) {
        RouteResponse response = new RouteResponse();
        response.id = route.getId();
        response.name = route.getName();
        response.direction = route.getDirection();
        return response;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDirection() { return direction; }
}
