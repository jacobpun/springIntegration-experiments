package org.punnoose.springintegrationdemo.service;

import org.punnoose.springintegrationdemo.domain.cancell.CancellationRequest;
import org.punnoose.springintegrationdemo.domain.cancell.CancellationStatus;

public class FakeCancellationServiceImpl implements CancellationsService {
	public CancellationStatus cancel(CancellationRequest cancellationRequest) {
		return new CancellationStatus();
	}
}