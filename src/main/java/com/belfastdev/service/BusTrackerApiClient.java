package com.belfastdev.service;

import com.belfastdev.model.BusRoute;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class BusTrackerApiClient {
    private final WebClient webClient;

    @Value("${bus.tracker.api.url:http://localhost:8000}")
    private String apiBaseUrl;

    public BusTrackerApiClient(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.build();
    }

    //Get all routes
    public Flux<BusRoute> getRoutes() {
        return webClient.get()
                .uri(apiBaseUrl + "/route/routes")
                .retrieve()
                .bodyToFlux(BusRoute.class);
    }
}
