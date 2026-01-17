package com.belfastdev.api;

import com.belfastdev.service.BusTrackerApiClient;

public class BusRouteController {
    private final BusTrackerApiClient client;

    public BusRoutesController(BusTrackerApiClient client) {
        this.client = client;
        System.out.println("BusRoutesController created");
    }

}
