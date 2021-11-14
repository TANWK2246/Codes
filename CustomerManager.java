/**
 * The type Customer manager.
*/
public class CustomerManager{
	/**
	 * Find an empty table and assign new customer to table.
	 *
	 * @param name          the name
	 * @param noOfPax       the no of pax
	 * @param tableArray    the table array
	 * @param customerArray the customer array
	 * @return the new customer object, or null if no suitable table is found
	 */
	public static Customer assignNewCustomerToTable(String name, int noOfPax, TableArray tableArray, CustomerArray customerArray) {
		int tableID = TableManager.findAnEmptyTable(noOfPax, tableArray);
		
		if(tableID == -1){
			return null;
		}else{
			TableManager.bookATable(tableID, tableArray);

			Customer customer = new Customer(name, noOfPax, tableArray.getTables().get(tableID));

			tableArray.getTables().get(tableID).setCustomer(customer);

			customerArray.getCustomers().add(customer);

			return customer;
		}

	}
}