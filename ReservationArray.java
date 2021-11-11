import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;
import java.io.Serializable;

public class ReservationArray implements Serializable{
	public ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	public ReservationArray(){}

	public int addNewReservation(Customer customer, LocalDateTime checkInTime){
		Reservation newReservation = new Reservation(this.reservations.size(), customer, checkInTime);
		this.reservations.add(newReservation);
		customer.setReservation(newReservation);
		return this.reservations.size() - 1;
	}

	public void updateReservationValidity(){
		for(Reservation i : reservations){
			Customer customer = i.updateValidity();
			if(customer != null){
				customer.getTable().setIsOccupied(false);
			}
		}
	}

	public int checkReservation(int reservationID) {
		for(Reservation i: this.reservations){
			if(i.getReservationID() == reservationID){
				if(i.getValidity() == true){
					return i.getCustomer().getTable().getTableID();
				}else{
					return -1;
				}
			}
		}
		return -2;
	}

	public int removeReservation(int reservationID){
		this.reservations.get(reservationID).setValidity(false);
		return this.reservations.get(reservationID).getCustomer().getTable().getTableID();
	}

}