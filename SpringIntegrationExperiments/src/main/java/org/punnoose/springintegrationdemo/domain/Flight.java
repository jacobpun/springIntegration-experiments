package org.punnoose.springintegrationdemo.domain;

import java.util.Date;

public class Flight {
	private String number;
	private Date scheduledDeparture;
	private String origin;
	private String destination;

	public Flight(String flightNumber) {
		setNumber(flightNumber);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getScheduledDeparture() {
		return scheduledDeparture;
	}

	public void setScheduledDeparture(Date scheduledDeparture) {
		this.scheduledDeparture = scheduledDeparture;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}