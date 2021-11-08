import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	public void editCustomer() {
		throw new UnsupportedOperationException();
	}

	public void assignNewCustomerToTable(TableManager tableManager) {
		Scanner sc = new Scanner(System.in);
		int noOfPax, tableID;
		String name;
		Customer customer;

		System.out.println("Enter Customer Name:");
		name = sc.nextLine();
		System.out.println("Enter number of pax:");
		noOfPax = sc.nextInt();

		tableID = tableManager.findAnEmptyTable(noOfPax);
		if(tableID == -1){
			System.out.println("Sorry! No suitable empty tables available!");
		}else{
			tableManager.bookATable(tableID);
			customer = new Customer(name, noOfPax, tableManager.getTable(tableID));
			tableManager.getTable(tableID).setCustomer(customer);
			customers.add(customer);

			System.out.println("Customer " + customer.getName() + " has been assigned to table number " + tableID);
		}
	}
}