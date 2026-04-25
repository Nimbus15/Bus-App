package com.belfastdev.api;

import com.belfastdev.dto.RouteResponse;
import com.belfastdev.dto.RouteStopResponse;
import com.belfastdev.service.BusTrackerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/routes")
public class RouteController {
    private static final Logger log = LoggerFactory.getLogger(RouteController.class);

    private final BusTrackerService busTrackerService;

    public RouteController(BusTrackerService busTrackerService) {
        this.busTrackerService = busTrackerService;
    }

    @GetMapping
    public Flux<RouteResponse> getAllRoutes() {
        log.debug("GET /api/v1/routes");
        return busTrackerService.getAllBusRoutes().map(RouteResponse::from);
    }

    @GetMapping("/{routeId}/stops")
    public Flux<RouteStopResponse> getRouteStops(@PathVariable UUID routeId) {
        log.debug("GET /api/v1/routes/{}/stops", routeId);
        return busTrackerService.getBusStops(routeId).map(RouteStopResponse::from);
    }
}
