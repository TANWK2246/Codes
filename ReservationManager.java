import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;
import java.io.Serializable;

public class ReservationManager{
	
	public static int createReservation(String checkInDateTime, Customer customer, int phone, ReservationArray reservationArray){
        LocalDateTime checkInTime = LocalDateTime.parse(checkInDateTime);

        customer.setPhone(phone);

        return reservationArray.addNewReservation(customer, checkInTime);
	}

	public static int checkReservation(int reservationID, ReservationArray reservationArray) {
        return reservationArray.checkReservation(reservationID);
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

	public static void updateReservationValidity(Restaurant restaurant){
		restaurant.getReservationArray().updateReservationValidity();
	}

    public static boolean validateReservationTime(String checkInDateTime){
        LocalDateTime checkInTime = LocalDateTime.parse(checkInDateTime);

		LocalDateTime now = LocalDateTime.now();
    	
		Duration duration = Duration.between(now, checkInTime);

        if(duration.toMinutes() < 60) return false;
        
        return true;
    }
}