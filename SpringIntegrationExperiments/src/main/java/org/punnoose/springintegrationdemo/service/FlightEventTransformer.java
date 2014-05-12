package org.punnoose.springintegrationdemo.service;

import java.util.Calendar;

import org.punnoose.springintegrationdemo.vo.Flight;
import org.punnoose.springintegrationdemo.vo.FlightDelayEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.util.Assert;

@MessageEndpoint
public class FlightEventTransformer {
	private FlightScheduler flightScheduler;

	@Autowired
	public FlightEventTransformer(FlightScheduler flightScheduer) {
		Assert.notNull(flightScheduer, "Scheduler should not be null");
		this.setFlightScheduler(flightScheduer);
	}

	public FlightScheduler getFlightScheduler() {
		return flightScheduler;
	}

	public void setFlightScheduler(FlightScheduler flightScheduler) {
		this.flightScheduler = flightScheduler;
	}

	public FlightDelayEvent convertToDelayEvent(String flightNumberAndDelay) {
		String[] splits = flightNumberAndDelay.split("[+]");
		Flight flight = this.flightScheduler.nextFlightForNumber(splits[0]);
		int hours = Integer.parseInt(splits[1].substring(0, 2));
		int minutes = Integer.parseInt(splits[1].substring(2));
		Calendar cal = Calendar.getInstance();
		cal.setTime(flight.getScheduledDeparture());
		cal.add(Calendar.HOUR, hours);
		cal.add(Calendar.MINUTE, minutes);
		return new FlightDelayEvent(flight, cal.getTime());
	}
}