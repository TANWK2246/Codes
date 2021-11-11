import java.time.LocalDateTime;
import java.time.Duration;

public class ReservationManager{
	
	public static int createReservation(String checkInDateTime, Customer customer, int phone, ReservationArray reservationArray){
        LocalDateTime checkInTime = LocalDateTime.parse(checkInDateTime);

        customer.setPhone(phone);

        return reservationArray.addNewReservation(customer, checkInTime);
	}

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

	public static int removeReservation(int reservationID, Restaurant restaurant) {
		int result = checkReservation(reservationID, restaurant.getReservationArray());
		if(result == -1){
			return -1;
		}else if(result == -2){
			return -2;
		}else{
			int tableID = restaurant.getReservationArray().removeReservation(reservationID);
			TableManager.releaseATable(tableID, restaurant.getTableArray());
			return tableID;
		}
		
	}

	public static void updateReservationValidity(ReservationArray reservationArray){
		for(Reservation reservation : reservationArray.getReservations()){
			Customer customer = reservation.updateValidity();
			if(customer != null){
				customer.getTable().setIsOccupied(false);
			}
		}
	}

    public static boolean validateReservationTime(String checkInDateTime){
        LocalDateTime checkInTime = LocalDateTime.parse(checkInDateTime);

		LocalDateTime now = LocalDateTime.now();
    	
		Duration duration = Duration.between(now, checkInTime);

        if(duration.toMinutes() < 60) return false;
        
        return true;
    }
}