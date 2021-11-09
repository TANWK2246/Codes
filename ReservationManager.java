import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;

public class ReservationManager {
	public ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	public void createReservation(TableManager tableManager, CustomerManager customerManager) {
		Scanner sc = new Scanner(System.in);
		int noOfPax, tableID, phone;
		String name;
		Customer customer;
		Reservation newReservation;

		System.out.println("Enter Customer Name:");
		name = sc.nextLine();
		System.out.println("Enter number of pax:");
		noOfPax = sc.nextInt();

		tableID = tableManager.findAnEmptyTable(noOfPax);
		if(tableID == -1){
			System.out.println("Sorry! No suitable empty tables available!");
		}else{
			System.out.println("Enter phone number:");
			phone = sc.nextInt();

			sc.nextLine();
			System.out.println("Enter Check In Time: (YYYY-MM-DDTHH:MM:SS) ");
			String dateTime = sc.nextLine();
			LocalDateTime checkInTime = LocalDateTime.parse(dateTime);

			LocalDateTime now = LocalDateTime.now();
    	
			Duration duration = Duration.between(now, checkInTime);

			if(duration.toMinutes() < 60){
				System.out.println("Can only make reservation 1 hour in advance!");
				return;
			}
			
			tableManager.bookATable(tableID);

			customer = new Customer(name, noOfPax, tableManager.getTable(tableID), phone);

			tableManager.getTable(tableID).setCustomer(customer);

			customerManager.addCustomer(customer);
			
			
			
			newReservation = new Reservation(reservations.size(), customer, checkInTime);

			customer.setReservation(newReservation);
			reservations.add(newReservation);

			System.out.println("Table number "+ tableID+ " has been reserved for  " + customer.getName());
		}
	}

	public void checkReservation() {
		throw new UnsupportedOperationException();
	}

	public void removeReservation() {
		throw new UnsupportedOperationException();
	}

	public void printReservations(){
		for(Reservation i : reservations){
			i.printReservation();
		}
	}

	public void updateReservationValidity(){
		for(Reservation i : reservations){
			i.updateValidity();
		}
	}
}