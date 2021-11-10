package com.funwithflights.task;

import com.funwithflights.messaging.FlightRouteSender;
import com.funwithflights.service.FlightRouteService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendFlightRoutesTask {

    private final FlightRouteService flightRoute;
    private final FlightRouteSender queueFlightRouteSender;

    public SendFlightRoutesTask(FlightRouteService flightRoute, FlightRouteSender queueFlightRouteSender) {
        this.flightRoute = flightRoute;
        this.queueFlightRouteSender = queueFlightRouteSender;
    }

    @Scheduled(fixedRate = 5000)
    public void sendRoutes() {
        flightRoute.retrieveRoutes().forEach(queueFlightRouteSender::send);
    }

}
