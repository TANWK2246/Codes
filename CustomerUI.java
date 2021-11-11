import java.util.Scanner;

public class CustomerUI{
	public static void NewCustomer(Restaurant restaurant) {
		Scanner sc = new Scanner(System.in);
		int noOfPax;
		String name;

		System.out.println("Enter Customer Name:");
		name = sc.nextLine();
		System.out.println("Enter number of pax:");
		noOfPax = sc.nextInt();

		Customer customer = CustomerManager.assignNewCustomerToTable(name, noOfPax, restaurant);

		if(customer == null){
			System.out.println("Sorry! No suitable empty tables available!");
		}else{
			System.out.println("Customer " + customer.getName() + " has been assigned to table number " + customer.getTable().getTableID());
		}
        
	}

}