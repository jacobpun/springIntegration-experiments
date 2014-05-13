package org.punnoose.springintegrationdemo.domain;

import java.util.Date;

public class FlightDelayEvent {
	private Flight flight;
	private Date estimatedDeparture;

	public FlightDelayEvent(Flight flight, Date estimatedDeparture) {
		setFlight(flight);
		setEstimatedDeparture(estimatedDeparture);
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Date getEstimatedDeparture() {
		return estimatedDeparture;
	}

	public void setEstimatedDeparture(Date estimatedDeparture) {
		this.estimatedDeparture = estimatedDeparture;
	}
}