package com.belfastdev.service;

import com.belfastdev.model.BusJourney;
import com.belfastdev.model.BusRoute;
import com.belfastdev.model.BusRouteStop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Profile("!mock")
public class BusTrackerApiClient implements BusTrackerService {
    private static final Logger log = LoggerFactory.getLogger(BusTrackerApiClient.class);

    private final WebClient webClient;

    public BusTrackerApiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<BusRoute> getAllBusRoutes() {
        log.debug("Fetching all bus routes");
        return webClient.get()
                .uri("/route/routes")
                .retrieve()
                .bodyToFlux(BusRoute.class);
    }

    @Override
    public Flux<BusRouteStop> getBusStops(UUID routeId) {
        log.debug("Fetching stops for route {}", routeId);
        return webClient.get()
                .uri("/route/routes/{id}/stops", routeId)
                .retrieve()
                .bodyToFlux(BusRouteStop.class);
    }

    @Override
    public Mono<BusJourney> addJourney(BusJourney busJourney) {
        log.debug("Creating journey on route {}", busJourney.getRouteId());
        return webClient.post()
                .uri("/journeys/start")
                .bodyValue(busJourney)
                .retrieve()
                .bodyToMono(BusJourney.class);
    }
}
