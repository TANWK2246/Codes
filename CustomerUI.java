import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The type Customer ui.
 */
public class CustomerUI{
	/**
	 * New customer ui. Prompt for customer details and attempt to assign the customer to a suitable table.
	 *
	 * @param restaurant the restaurant
	 */
	public static void newCustomer(Restaurant restaurant) {
		int noOfPax;
		String name;

		System.out.println("Enter customer details:");
		name = promptForCustomerNameInput();
		noOfPax = promptForNoOfPaxInput();

		Customer customer = CustomerManager.assignNewCustomerToTable(name, noOfPax, restaurant.getTableArray(), restaurant.getCustomerArray());

		if(customer == null){
			System.out.println("Sorry! No suitable empty tables available!");
			System.out.println("Going back to Home Page...");
		}else{
			System.out.println("Customer " + customer.getName() + " has been assigned to table number " + customer.getTable().getTableID());
		}
	}

	/**
	 * Prompt for customer name input string.
	 *
	 * @return the name input string
	 */
	public static String promptForCustomerNameInput(){
		Scanner sc = new Scanner(System.in);
		String input;

		while(true){
			try{
				System.out.println("Enter Customer Name:");
				input = sc.nextLine();
				break;
			}catch (InputMismatchException e){
				System.out.println("Invalid name. Please enter again!");
			}
		}
		
		return input;
	}

	/**
	 * Prompt for no of pax input int. No of pax must be from 1 to 10.
	 *
	 * @return the no of pax input int
	 */
	public static int promptForNoOfPaxInput() {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter Number of Pax:");
				input = sc.nextInt();sc.nextLine();
				if(input <= 0 | input > 10){
					System.out.println("Please enter a number from 1 to 10.");
					continue;
				}
				break;
			}catch (InputMismatchException e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
		
		return input;
	}

}