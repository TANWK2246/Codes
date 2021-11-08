import java.time.LocalDateTime;

public class Reservation {
	private int reservationID;
	private LocalDateTime checkInTime;
	private boolean validity;
	public Customer customer;
	

	public int getReservationID() {
		return this.reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public LocalDateTime getCheckInTime() {
		return this.checkInTime;
	}

	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public boolean getValidity() {
		return this.validity;
	}

	public void setValidity(boolean validity) {
		this.validity = validity;
	}

	public void updateValidity() {
		throw new UnsupportedOperationException();
	}
}