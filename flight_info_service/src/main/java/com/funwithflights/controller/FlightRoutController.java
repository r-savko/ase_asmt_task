package com.funwithflights.controller;

import com.funwithflights.repository.model.FlightRoute;
import com.funwithflights.service.FlightRouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FlightRoutController {

    private final FlightRouteService flightRouteService;

    public FlightRoutController(FlightRouteService flightRouteService) {
        this.flightRouteService = flightRouteService;
    }

    @GetMapping("/routes")
    public @ResponseBody
    Iterable<FlightRoute> fetchAllFlightRoutes() {
        return flightRouteService.fetchAllFlightRoutes();
    }


}
