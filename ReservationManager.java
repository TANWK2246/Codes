import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;
import java.io.Serializable;

public class ReservationManager{
	
	public static void createReservation(String checkInDateTime, Customer customer, int phone, ReservationArray reservationArray){
		Reservation newReservation;

        LocalDateTime checkInTime = LocalDateTime.parse(checkInDateTime);

        customer.setPhone(phone);

        System.out.println("Reservation ID: "+ reservationArray.addNewReservation(customer, checkInTime));
	}

	public static int checkReservation(int reservationID, ReservationArray reservationArray) {
        return reservationArray.checkReservation(reservationID);
	}

	public static void removeReservation(int reservationID, Restaurant restaurant) {
		TableManager.releaseATable(restaurant.getReservationArray().removeReservation(reservationID), restaurant.getTableArray());
	}

	
	public static void updateReservationValidity(Restaurant restaurant){
		restaurant.getReservationArray().updateReservationValidity(restaurant.getTableArray());
	}

    public static boolean validateReservationTime(String checkInDateTime){
        LocalDateTime checkInTime = LocalDateTime.parse(checkInDateTime);

		LocalDateTime now = LocalDateTime.now();
    	
		Duration duration = Duration.between(now, checkInTime);

        if(duration.toMinutes() < 60) return false;
        
        return true;
    }
}