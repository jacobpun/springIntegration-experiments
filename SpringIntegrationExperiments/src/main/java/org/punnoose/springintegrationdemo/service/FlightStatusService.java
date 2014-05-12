package org.punnoose.springintegrationdemo.service;

import org.punnoose.springintegrationdemo.vo.FlightDelayEvent;
import org.punnoose.springintegrationdemo.vo.FlightStatus;

public interface FlightStatusService {
	FlightStatus updateStatus(FlightDelayEvent flightDelayEvent);

}