import java.util.Scanner;

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
		System.out.println("Enter Check In Time: (YYYY-MM-DDTHH:MM:SS) (Enter -1 to cancel)");
		checkInDateTime = sc.nextLine();
		while(ReservationManager.validateReservationTime(checkInDateTime) == false){
			System.out.println("Can only make reservation 1 hour in advance!");
			System.out.println("Enter Check In Time: (YYYY-MM-DDTHH:MM:SS) ");
			checkInDateTime = sc.nextLine();
			if(checkInDateTime.equals("-1")){
				System.out.println("Action cancelled. Going back to Home Page.");
				return;
			}
		}
		
		Customer customer = CustomerManager.assignNewCustomerToTable(name, noOfPax, restaurant);

		if(customer == null){
			System.out.println("Sorry! No suitable empty tables available!");
			return;
		}else{
			System.out.println("Customer " + customer.getName() + " has been assigned to table number " + customer.getTable().getTableID());
		}
		
		System.out.println("Enter phone number:");
		phone = sc.nextInt();

		System.out.println("ReservationID: " + ReservationManager.createReservation(checkInDateTime, customer, phone, restaurant.getReservationArray()));
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
		System.out.println("Enter Reservation ID to remove:");
		reservationID = sc.nextInt();

		int result = ReservationManager.removeReservation(reservationID, restaurant);
		if(result == -1){
			System.out.println("This reservation had been removed.");
		}else if(result == -2){
			System.out.println("Reservation not found");
		}else{
			System.out.println("Reservation removed. Table number: " + result + " is released.");
		}
	}
}