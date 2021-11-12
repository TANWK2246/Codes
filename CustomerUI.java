import java.util.Scanner;
import java.util.InputMismatchException;

public class CustomerUI{
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

	public static int promptForNoOfPaxInput() {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter Number of Pax:");
				input = sc.nextInt();sc.nextLine();
				if(input <= 0 | input > 10){
					System.out.println("Please enter a number from 0 to 10.");
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