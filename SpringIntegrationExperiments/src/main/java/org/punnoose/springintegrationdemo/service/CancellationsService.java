package org.punnoose.springintegrationdemo.service;

import org.punnoose.springintegrationdemo.domain.cancell.CancellationRequest;
import org.punnoose.springintegrationdemo.domain.cancell.CancellationStatus;

public interface CancellationsService {
	public CancellationStatus cancel(CancellationRequest cancellationRequest);
}
