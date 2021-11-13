import java.time.LocalDateTime;
import java.time.Duration;
import java.io.Serializable;

public class Reservation implements Serializable{
	private int reservationID;
	private LocalDateTime checkInTime;
	private boolean validity;
	private Customer customer;

	public Customer getCustomer() {
		return this.customer;
	}

	public Reservation(){}
	
	public Reservation(int reservationID, Customer customer, LocalDateTime checkInTime){
		this.customer = customer;
		this.reservationID = reservationID;
		this.checkInTime = checkInTime;
		this.validity = true;
	}

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

	public Customer updateValidity() {
		if(this.getValidity() == false) return null;
		LocalDateTime now = LocalDateTime.now();
    	
		Duration duration = Duration.between(this.checkInTime, now);

		if(duration.toMinutes() > 2){
			this.setValidity(false);
			return this.customer;	
		}

		return null;
	}

	
}