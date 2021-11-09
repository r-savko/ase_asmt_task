package com.funwithflights.service;

import com.funwithflights.model.FlightRoute;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AseFlightRouteService implements FlightRouteService {

    @Value("${route.providers.ase.urls}")
    private String[] routUrls;

    final RestTemplate restTemplate;

    public AseFlightRouteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<FlightRoute> retrieveRoutes() {

        return Arrays.stream(routUrls)
            .flatMap(r -> Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(r, FlightRoute[].class))))
            .collect(Collectors.toList());

    }
}
