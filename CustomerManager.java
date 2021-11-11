public class CustomerManager{
	public CustomerManager(){}

	public static Customer assignNewCustomerToTable(String name, int noOfPax, Restaurant restaurant) {
		int tableID = TableManager.tableFinder(noOfPax, restaurant.getTableArray());
		
		if(tableID == -1){
			return null;
		}else{
			TableManager.bookATable(tableID, restaurant.getTableArray());

			Customer customer = new Customer(name, noOfPax, restaurant.getTableArray().getTable(tableID));

			restaurant.getTableArray().getTable(tableID).setCustomer(customer);

			restaurant.getCustomerArray().addCustomer(customer);

			return customer;
		}

	}
}