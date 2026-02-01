package com.belfastdev.api;

import com.belfastdev.model.BusJourney;
import com.belfastdev.model.BusRoute;
import com.belfastdev.model.BusRouteStop;
import com.belfastdev.service.BusTrackerApiClient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class BusRoutesController {
    private final BusTrackerApiClient client;

    @Autowired
    public BusRoutesController(BusTrackerApiClient client) {
        this.client = client;
        System.out.println("BusRoutesController created");
    }

    @GetMapping("/BusRoutes")
    public Flux<BusRoute> getAllBusRoutes() {
        System.out.println("getAllBusRoutes endpoint hit");
        return client.getAllBusRoutes();
    }

    @GetMapping("/routes/{routeId}/stops")
    public Flux<BusRouteStop> getBusStops(@PathVariable("routeId") UUID id){
        System.out.println("getStop endpoint hit");
        return client.getBusStops(id);
    }

    @PostMapping("/journeys/start")
    public void addJourney(@Valid @NotNull @RequestBody BusJourney busJourney){
        client.addJourney(busJourney);
    }

    @GetMapping("/BusRoutesTest")
    public Mono<String> testCall(){
        System.out.println("BusRoutesTest endpoint hit");
        return client.getAllBusRoutes()
                .collectList()
                .map(Object::toString)
                .doOnNext(System.out::println);
    }
}
