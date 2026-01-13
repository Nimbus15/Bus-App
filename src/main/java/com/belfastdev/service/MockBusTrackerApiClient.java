package com.belfastdev.service;

import com.belfastdev.model.BusRoute;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@Profile("mock")
public class MockBusTrackerApiClient extends BusTrackerApiClient{

    public MockBusTrackerApiClient(WebClient.Builder webClientBuilder) {
        super(null);
    }

    @Override
    public Flux<BusRoute> getRoutes(){
        // Return fask test dawta
        List<BusRoute> mockBusRoutes = List.of(
                new BusRoute("1L", "City Center Loop"),
                new BusRoute("2L", "Airport Express"),
                new BusRoute("3L", "University Line")
        );

        return Flux.fromIterable(mockBusRoutes);
    }
}
