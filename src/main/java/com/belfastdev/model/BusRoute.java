package com.belfastdev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusRoute {
    private String id;
    private String name;
    private String direction;

    public BusRoute() {}

    public BusRoute(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }
}
