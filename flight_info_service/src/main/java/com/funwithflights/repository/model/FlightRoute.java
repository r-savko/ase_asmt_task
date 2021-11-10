package com.funwithflights.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlightRoute {

    String airline;
    String sourceAirport;
    String destinationAirport;
    String codeShare;
    Integer stops;
    String equipment;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public FlightRoute setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAirline() {
        return airline;
    }

    public FlightRoute setAirline(String airline) {
        this.airline = airline;
        return this;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public FlightRoute setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
        return this;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public FlightRoute setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
        return this;
    }

    public String getCodeShare() {
        return codeShare;
    }

    public FlightRoute setCodeShare(String codeShare) {
        this.codeShare = codeShare;
        return this;
    }

    public Integer getStops() {
        return stops;
    }

    public FlightRoute setStops(Integer stops) {
        this.stops = stops;
        return this;
    }

    public String getEquipment() {
        return equipment;
    }

    public FlightRoute setEquipment(String equipment) {
        this.equipment = equipment;
        return this;
    }
}
