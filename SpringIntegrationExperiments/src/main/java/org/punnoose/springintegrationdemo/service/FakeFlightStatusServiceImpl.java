package org.punnoose.springintegrationdemo.service;

import org.punnoose.springintegrationdemo.vo.Flight;
import org.punnoose.springintegrationdemo.vo.FlightDelayEvent;
import org.punnoose.springintegrationdemo.vo.FlightStatus;
import org.springframework.integration.annotation.Payload;
import org.springframework.integration.annotation.Publisher;

public class FakeFlightStatusServiceImpl implements FlightStatusService {

	@Publisher(channel="statisticsChannel")
	public FlightStatus updateStatus(@Payload FlightDelayEvent flightDelayEvent) {

		Flight flight = flightDelayEvent.getFlight();
		flight.setScheduledDeparture(flightDelayEvent.getEstimatedDeparture());
		
		FlightStatus status = new FlightStatus();
		status.setFlight(flight);
		
		return status;
	}
}