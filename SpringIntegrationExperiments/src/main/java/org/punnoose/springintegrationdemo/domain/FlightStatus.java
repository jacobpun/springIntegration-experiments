package org.punnoose.springintegrationdemo.domain;


public class FlightStatus {
	private Flight flight;
	private String status;
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
