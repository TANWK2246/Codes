import java.time.LocalDateTime;
import java.time.Duration;
import java.io.Serializable;

/**
 * The type Reservation.
 */
public class Reservation implements Serializable{
	/**
	 * The Reservation id.
	 */
	private int reservationID;
	/**
	 * The Check in time.
	 */
	private LocalDateTime checkInTime;
	/**
	 * The Validity.
	 */
	private boolean validity;
	/**
	 * The Customer.
	 */
	private Customer customer;

	/**
	 * Instantiates a new Reservation.
	 */
	public Reservation(){}

	/**
	 * Instantiates a new Reservation.
	 *
	 * @param reservationID the reservation id
	 * @param customer      the customer
	 * @param checkInTime   the check in time
	 */
	public Reservation(int reservationID, Customer customer, LocalDateTime checkInTime){
		this.customer = customer;
		this.reservationID = reservationID;
		this.checkInTime = checkInTime;
		this.validity = true;
	}

	/**
	 * Gets reservation id.
	 *
	 * @return the reservation id
	 */
	public int getReservationID() {
		return this.reservationID;
	}

	/**
	 * Sets reservation id.
	 *
	 * @param reservationID the reservation id
	 */
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	/**
	 * Gets check in time.
	 *
	 * @return the check in time
	 */
	public LocalDateTime getCheckInTime() {
		return this.checkInTime;
	}

	/**
	 * Sets check in time.
	 *
	 * @param checkInTime the check in time
	 */
	public void setCheckInTime(LocalDateTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	/**
	 * Gets validity.
	 *
	 * @return the validity
	 */
	public boolean getValidity() {
		return this.validity;
	}

	/**
	 * Sets validity.
	 *
	 * @param validity the validity
	 */
	public void setValidity(boolean validity) {
		this.validity = validity;
	}

	
	/**
	 * Gets customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Update validity of reservation, validity is set to false if the duration between reservation check in time and the current time is more than 15 minutes
	 *
	 * @return the customer of the reservation if it is updated to invalid
	 */
	public Customer updateValidity() {
		if(this.getValidity() == false) return null;
		LocalDateTime now = LocalDateTime.now();
    	
		Duration duration = Duration.between(this.checkInTime, now);

		if(duration.toMinutes() > 15){
			this.setValidity(false);
			return this.customer;	
		}

		return null;
	}

	
}