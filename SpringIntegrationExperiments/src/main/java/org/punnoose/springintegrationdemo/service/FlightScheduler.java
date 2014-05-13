package org.punnoose.springintegrationdemo.service;

import org.punnoose.springintegrationdemo.domain.Flight;

public interface FlightScheduler {

	Flight nextFlightForNumber(String flightNumber);

}
