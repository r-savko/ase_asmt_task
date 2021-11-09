package com.funwithflights.task;

import com.funwithflights.messaging.SendFlightRouteService;
import com.funwithflights.service.FlightRouteService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendFlightRoutesTask {

    private final FlightRouteService flightRoute;
    private final SendFlightRouteService queueSendFlightRouteService;

    public SendFlightRoutesTask(FlightRouteService flightRoute, SendFlightRouteService queueSendFlightRouteService) {
        this.flightRoute = flightRoute;
        this.queueSendFlightRouteService = queueSendFlightRouteService;
    }

    @Scheduled(fixedRate = 5000)
    public void sendRoutes() {
        flightRoute.retrieveRoutes().forEach(queueSendFlightRouteService::send);
    }

}
