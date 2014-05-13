package org.punnoose.springintegrationdemo.service;

import org.punnoose.springintegrationdemo.domain.FlightDelayEvent;
import org.punnoose.springintegrationdemo.domain.FlightStatus;

public interface FlightStatusService {
	FlightStatus updateStatus(FlightDelayEvent flightDelayEvent);

}