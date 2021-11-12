import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.Serializable;

public class ReservationArray implements Serializable{
	public ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	public ReservationArray(){}

	public int addNewReservation(Customer customer, LocalDateTime checkInTime){
		Reservation newReservation = new Reservation(this.reservations.size(), customer, checkInTime);
		this.reservations.add(newReservation);
		return this.reservations.size() - 1;
	}

	public int removeReservation(int reservationID){
		this.reservations.get(reservationID).setValidity(false);
		return this.reservations.get(reservationID).getCustomer().getTable().getTableID();
	}

	public ArrayList<Reservation> getReservations(){
		return this.reservations;
	}

}