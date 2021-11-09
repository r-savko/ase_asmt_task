package com.funwithflights.model;


public class FlightRoute {

    String airline;
    String sourceAirport;
    String destinationAirport;
    String codeShare;
    Integer stops;
    String equipment;

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

    @Override
    public String toString() {
        return "FlightRoute{" +
            "airline='" + airline + '\'' +
            ", sourceAirport='" + sourceAirport + '\'' +
            ", destinationAirport='" + destinationAirport + '\'' +
            ", codeShare='" + codeShare + '\'' +
            ", stops=" + stops +
            ", equipment='" + equipment + '\'' +
            '}';
    }
}
