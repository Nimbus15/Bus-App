package com.belfastdev.api;

import com.belfastdev.model.BusRoute;
import com.belfastdev.service.BusTrackerApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BusRoutesController {
    private final BusTrackerApiClient client;

    public BusRoutesController(BusTrackerApiClient client) {
        this.client = client;
        System.out.println("BusRoutesController created");
    }

    @GetMapping("/BusRoutes")
    public Flux<BusRoute> busRoutes() {
        System.out.println("BusRoutes endpoint hit");
        return client.getRoutes();
    }

    @GetMapping("/BusRoutesTest")
    public Mono<String> testCall(){
        System.out.println("BusRoutesTest endpoint hit");
        return client.getRoutes()
                .collectList()
                .map(Object::toString)
                .doOnNext(System.out::println);
    }

}
