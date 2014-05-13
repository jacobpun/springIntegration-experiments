package org.punnoose.springintegrationdemo.filter;

import java.util.regex.Pattern;

import org.punnoose.springintegrationdemo.domain.cancell.CancellationRequest;

public class CancellationRequestFilter {

	private Pattern pattern;

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}
	
	public boolean accept(CancellationRequest cancellationRequest){
		String code = cancellationRequest.getReservationCode();
		return code != null && pattern.matcher(code).matches();
	}
}