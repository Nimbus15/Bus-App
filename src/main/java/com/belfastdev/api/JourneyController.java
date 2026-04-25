package com.belfastdev.api;

import com.belfastdev.dto.CreateJourneyRequest;
import com.belfastdev.dto.JourneyResponse;
import com.belfastdev.model.BusJourney;
import com.belfastdev.service.BusTrackerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/journeys")
public class JourneyController {
    private static final Logger log = LoggerFactory.getLogger(JourneyController.class);

    private final BusTrackerService busTrackerService;

    public JourneyController(BusTrackerService busTrackerService) {
        this.busTrackerService = busTrackerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<JourneyResponse> createJourney(@Valid @RequestBody CreateJourneyRequest request) {
        log.debug("POST /api/v1/journeys - route {}", request.getRouteId());
        BusJourney journey = new BusJourney(request.getRouteId(), request.getStartStopId(), request.getEndStopId());
        return busTrackerService.addJourney(journey).map(JourneyResponse::from);
    }
}
