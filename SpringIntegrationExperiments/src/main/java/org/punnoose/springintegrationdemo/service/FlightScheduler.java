package org.punnoose.springintegrationdemo.service;

import org.punnoose.springintegrationdemo.vo.Flight;

public interface FlightScheduler {

	Flight nextFlightForNumber(String flightNumber);

}
