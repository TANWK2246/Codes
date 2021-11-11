import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;
import java.io.Serializable;

public class ReservationUI{

	public static void reservationCreator(Restaurant restaurant){
		Scanner sc = new Scanner(System.in);
		int noOfPax, phone;
		String name, checkInDateTime;

		System.out.println("Enter Customer Name:");
		name = sc.nextLine();
		System.out.println("Enter Number of pax:");
		noOfPax = sc.nextInt();

		sc.nextLine();
		System.out.println("Enter Check In Time: (YYYY-MM-DDTHH:MM:SS) ");
		checkInDateTime = sc.nextLine();
		while(ReservationManager.validateReservationTime(checkInDateTime) == false){
			System.out.println("Can only make reservation 1 hour in advance!");
			System.out.println("Enter Check In Time: (YYYY-MM-DDTHH:MM:SS) ");
			checkInDateTime = sc.nextLine();
		}
		
		Customer customer = CustomerManager.assignNewCustomerToTable(name, noOfPax, restaurant);

		if(customer == null) return;
		
		System.out.println("Enter phone number:");
		phone = sc.nextInt();

		ReservationManager.createReservation(checkInDateTime, customer, phone, restaurant.getReservationArray());

	}

	public static void reservationViewer(Restaurant restaurant){
		int reservationID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Reservation ID to check:");
		reservationID = sc.nextInt();

		int result = ReservationManager.checkReservation(reservationID, restaurant.getReservationArray());
		if(result == -1){
			System.out.println("Reservation removed");
		}else if(result == -2){
			System.out.println("Reservation not found");
		}else{
			System.out.println("Reservation found. Table number: " + result);
		}
	}


	public static void reservationRemover(Restaurant restaurant){
		int reservationID;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Reservation ID to check:");
		reservationID = sc.nextInt();

		ReservationManager.removeReservation(reservationID, restaurant);
	}
}