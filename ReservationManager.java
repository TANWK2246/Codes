import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.Duration;

/**
 * The type Reservation manager.
 */
public class ReservationManager{
	
	/**
	 * Create reservation int.
	 *
	 * @param checkInDateTime  the check in date time
	 * @param customer         the customer
	 * @param phone            the phone
	 * @param reservationArray the reservation array
	 * @return the int
	 */
	public static int createReservation(String checkInDateTime, Customer customer, int phone, ReservationArray reservationArray){
        LocalDateTime checkInTime = LocalDateTime.parse(checkInDateTime);

        customer.setPhone(phone);

		Reservation newReservation = new Reservation(reservationArray.getReservations().size(), customer, checkInTime);
		reservationArray.getReservations().add(newReservation);
		return newReservation.getReservationID();
	}

	/**
	 * Check if reservation exists and is still valid.
	 *
	 * @param reservationID    the reservation id
	 * @param reservationArray the reservation array
	 * @return the table ID, if the reservatione exists and valid, -1 if the reservation invalid, -2 if the reservation not found
	 */
	public static int checkReservation(int reservationID, ReservationArray reservationArray) {
        for(Reservation i: reservationArray.getReservations()){
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

	/**
	 * Remove reservation.
	 *
	 * @param reservationID 		the reservation id
	 * @param reservationArray    	the restaurant array
	 * @return the table ID of the reservation removed.
	 */
	public static int removeReservation(int reservationID, ReservationArray reservationArray) {
		int result = checkReservation(reservationID, reservationArray);
		if(result == -1){
			return -1;
		}else if(result == -2){
			return -2;
		}else{
			Reservation reservation = reservationArray.getReservations().get(reservationID);
			reservation.setValidity(false);
			Table table = reservation.getCustomer().getTable();
			table.setIsOccupied(false);
			
			return table.getTableID();

		}
		
	}

	/**
	 * Update reservation validity and set the table of the removed reservation to not occupied.
	 *
	 * @param reservationArray the reservation array
	 */
	public static void updateReservationValidity(ReservationArray reservationArray){
		for(Reservation reservation : reservationArray.getReservations()){
			Customer customer = reservation.updateValidity();
			if(customer != null){
				customer.getTable().setIsOccupied(false);
			}
		}
	}

	/**
	 * Validate reservation time. Reservation time must be at least 1 hour before the current time, within the operating hour of the restaurant and not beyond tomorrow.
	 *
	 * @param checkInDateTime the check in date time
	 * @return the true if the check in date time is valid
	 */
    public static boolean validateReservationTime(String checkInDateTime){
        LocalDateTime checkInTime = LocalDateTime.parse(checkInDateTime);

		LocalDateTime now = LocalDateTime.now();
		Duration duration = Duration.between(now, checkInTime);
        if(duration.toMinutes() < 2) return false;

		LocalTime time = checkInTime.toLocalTime();

		if(time.compareTo(LocalTime.of(10, 00)) < 0) return false;
		if(time.compareTo(LocalTime.of(23, 30)) > 0) return false;

		if(checkInTime.toLocalDate().compareTo(LocalDate.now().plusDays(1)) > 0) return false;
        
        return true;
    }
}