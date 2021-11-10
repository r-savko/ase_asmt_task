package com.funwithflights.repository;

import com.funwithflights.repository.model.FlightRoute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRouteRepository extends CrudRepository<FlightRoute, Long> {

}
