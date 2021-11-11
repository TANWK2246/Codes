import java.util.ArrayList;
import java.io.Serializable;

public class CustomerArray implements Serializable{
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	public CustomerArray(){}

	public void addCustomer(Customer customer){
		this.customers.add(customer);
	}

}