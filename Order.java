import java.util.ArrayList;
import java.io.Serializable;

/**
 * The type Order.
 */
public class Order implements Serializable{
	/**
	 * The Item order.
	 */
	private ArrayList<ItemOrder> itemOrder = new ArrayList<ItemOrder>();
	/**
	 * The Created by.
	 */
	private Staff created_by;

	/**
	 * Instantiates a new Order.
	 */
	public Order(){}

	/**
	 * Instantiates a new Order.
	 *
	 * @param staff    the staff
	 * @param customer the customer
	 */
	public Order(Staff staff, Customer customer){
		this.created_by = staff;
	}

	/**
	 * Print order.
	 *
	 * @return the number of item order
	 */
	public int printOrder(){
		String formatInfo = "%s\t%-20.20s %-3s\n";
		System.out.format(formatInfo,"ID", "Item Name", "Quantity");


		int counter = 0;
		for(ItemOrder i : itemOrder){
			System.out.format(formatInfo, String.valueOf(counter), i.getItem().getName(), String.valueOf(i.getQuantity()));
			counter++;
		}
		System.out.println();
		return counter;
	}

	
	/**
	 * Print order with subtotal.
	 */
	public void printOrderWithSubtotal(){
		String formatInfo = "%-3d %-20.20s\tS$ %7.2f\n";

		for(ItemOrder i : itemOrder){
			System.out.format(formatInfo, i.getQuantity(), i.getItem().getName(), i.calculateSubtotal());
		}
	}
	
	/**
	 * Calculate initial total price double.
	 *
	 * @return the initial total price
	 */
	public double calculateInitialTotalPrice(){
		double total = 0;
		for(ItemOrder i : itemOrder){
			total += i.calculateSubtotal();
		}
		return total;
	}
	
	/**
	 * Gets the staff who created the order.
	 *
	 * @return the staff who created the order
	 */
	public Staff getCreated_by() {
		return this.created_by;
	}

	/**
	 * Gets the array list of item order.
	 *
	 * @return the array list of item order
	 */
	public ArrayList<ItemOrder> getItemOrder() {
		return this.itemOrder;
	}
}