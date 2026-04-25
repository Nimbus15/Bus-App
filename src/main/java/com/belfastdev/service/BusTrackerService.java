package com.belfastdev.service;

import com.belfastdev.model.BusJourney;
import com.belfastdev.model.BusRoute;
import com.belfastdev.model.BusRouteStop;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BusTrackerService {
    Flux<BusRoute> getAllBusRoutes();
    Flux<BusRouteStop> getBusStops(UUID routeId);
    Mono<BusJourney> addJourney(BusJourney busJourney);
}
