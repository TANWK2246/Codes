import java.util.ArrayList;
import java.io.Serializable;

/**
 * The type Customer array.
 */
public class CustomerArray implements Serializable{
	/**
	 * The Customers.
	 */
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	/**
	 * Instantiates a new Customer array.
	 */
	public CustomerArray(){}

	/**
	 * Gets the array list of customers.
	 *
	 * @return the array list of customers
	 */
	public ArrayList<Customer> getCustomers(){
		return this.customers;
	}

}