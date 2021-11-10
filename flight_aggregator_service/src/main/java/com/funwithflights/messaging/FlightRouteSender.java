package com.funwithflights.messaging;

import com.funwithflights.model.FlightRoute;

public interface FlightRouteSender {

    void send(FlightRoute flightRoute);

}
