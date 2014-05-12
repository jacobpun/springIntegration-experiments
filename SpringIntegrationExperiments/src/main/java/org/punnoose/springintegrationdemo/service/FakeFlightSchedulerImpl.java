package org.punnoose.springintegrationdemo.service;

import java.util.Date;

import org.punnoose.springintegrationdemo.vo.Flight;

public class FakeFlightSchedulerImpl implements FlightScheduler {
	public Flight nextFlightForNumber(String flightNumber) {
		Flight flight = new Flight(flightNumber);
		flight.setScheduledDeparture(new Date());
		flight.setOrigin("JFK");
		flight.setDestination("LAX");
		return flight;
	}
}