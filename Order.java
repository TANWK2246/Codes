import java.util.ArrayList;
import java.io.Serializable;

public class Order implements Serializable{
	private ArrayList<ItemOrder> itemOrder = new ArrayList<ItemOrder>();
	private Staff created_by;

	public Order(){}

	public Order(Staff staff, Customer customer){ 
		this.created_by = staff;
	}

	public void addItemOrder(ItemOrder itemOrder){
		this.itemOrder.add(itemOrder);
	}

	public void removeItemOrder(int itemID){
		this.itemOrder.remove(itemID);
	}

	public void editQuantityofItemOrder(int itemID, int quantity){
		this.itemOrder.get(itemID).setQuantity(quantity);
	}

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

	public void printOrderWithSubtotal(){
		String formatInfo = "%-3d %-20.20s\tS$ %7.2f\n";

		for(ItemOrder i : itemOrder){
			System.out.format(formatInfo, i.getQuantity(), i.getItem().getName(), i.calculateSubtotal());
		}
	}
	
	public double calculateInitialTotalPrice(){
		double total = 0;
		for(ItemOrder i : itemOrder){
			total += i.calculateSubtotal();
		}
		return total;
	}

	public Staff getCreated_by() {
		return this.created_by;
	}

	public ArrayList<ItemOrder> getItemOrder() {
		return this.itemOrder;
	}
}