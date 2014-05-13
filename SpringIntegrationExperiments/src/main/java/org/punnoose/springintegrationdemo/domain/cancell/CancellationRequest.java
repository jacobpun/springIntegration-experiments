package org.punnoose.springintegrationdemo.domain.cancell;

public class CancellationRequest {
	private String reservationCode;

	public CancellationRequest(String reservationCode) {
		setReservationCode(reservationCode);
	}

	public String getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}
}