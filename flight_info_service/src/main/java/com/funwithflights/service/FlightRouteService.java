package com.funwithflights.service;

import com.funwithflights.repository.FlightRouteRepository;
import com.funwithflights.repository.model.FlightRoute;
import org.springframework.stereotype.Component;

@Component
public class FlightRouteService {

    private final FlightRouteRepository repository;

    public FlightRouteService(FlightRouteRepository repository) {
        this.repository = repository;
    }

    public Iterable<FlightRoute> fetchAllFlightRoutes() {
        return repository.findAll();
    }

    public void addFlightRoute(FlightRoute flightRoute) {
        repository.save(flightRoute);
    }

}
