package com.belfastdev.service;

import com.belfastdev.model.BusJourney;
import com.belfastdev.model.BusRoute;
import com.belfastdev.model.BusRouteStop;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@Profile("mock")
public class MockBusTrackerApiClient implements BusTrackerService {

    @Override
    public Flux<BusRoute> getAllBusRoutes() {
        return Flux.fromIterable(List.of(
                new BusRoute("1L", "City Center Loop"),
                new BusRoute("2L", "Airport Express"),
                new BusRoute("3L", "University Line")
        ));
    }

    @Override
    public Flux<BusRouteStop> getBusStops(UUID routeId) {
        return Flux.fromIterable(List.of(
                new BusRouteStop("stop-1", "Main Street"),
                new BusRouteStop("stop-2", "City Hall"),
                new BusRouteStop("stop-3", "Central Park")
        ));
    }

    @Override
    public Mono<BusJourney> addJourney(BusJourney busJourney) {
        return Mono.just(busJourney);
    }
}
