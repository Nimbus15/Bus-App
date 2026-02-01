package com.belfastdev.service;

import com.belfastdev.model.BusJourney;
import com.belfastdev.model.BusRoute;
import com.belfastdev.model.BusRouteStop;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
public class BusTrackerApiClient {
    private final WebClient webClient;

    @Value("${bus.tracker.api.url:http://localhost:8000}")
    private String apiBaseUrl;

    public BusTrackerApiClient(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.build();
    }

    //Get all routes
    public Flux<BusRoute> getAllBusRoutes() {
        return webClient.get()
                .uri(apiBaseUrl + "/route/routes")
                .retrieve()
                .bodyToFlux(BusRoute.class);
    }

    public Flux<BusRouteStop> getBusStops(UUID routeId){
        System.out.println("getBusStops endpoint hit");
        return webClient.get()
                .uri(apiBaseUrl + "/route/routes/" + routeId + "/stops")
                .retrieve()
                .bodyToFlux(BusRouteStop.class);
    }

    public @Nullable BusJourney addJourney(@Valid @NotNull @RequestBody BusJourney busJourney){
        return webClient.post()
                .uri(apiBaseUrl + "/journeys/start")
                .bodyValue(busJourney)
                .retrieve()
                .bodyToMono(BusJourney.class)
                .block();
    }
}
