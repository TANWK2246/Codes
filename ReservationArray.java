import java.util.ArrayList;
import java.io.Serializable;


/**
 * The type Reservation array.
 */
public class ReservationArray implements Serializable{
	/**
	 * The Reservations.
	 */
	public ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	/**
	 * Instantiates a new Reservation array.
	 */
	public ReservationArray(){}
	
	/**
	 * Get reservations array list.
	 *
	 * @return the array list
	 */
	public ArrayList<Reservation> getReservations(){
		return this.reservations;
	}

}