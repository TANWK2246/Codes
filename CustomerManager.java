public class CustomerManager{
	public CustomerManager(){}

	public static Customer assignNewCustomerToTable(String name, int noOfPax, TableArray tableArray, CustomerArray customerArray) {
		int tableID = TableManager.tableFinder(noOfPax, tableArray);
		
		if(tableID == -1){
			return null;
		}else{
			TableManager.bookATable(tableID, tableArray);

			Customer customer = new Customer(name, noOfPax, tableArray.getTable(tableID));

			tableArray.getTable(tableID).setCustomer(customer);

			customerArray.addCustomer(customer);

			return customer;
		}

	}
}