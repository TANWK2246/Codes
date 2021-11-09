import java.util.ArrayList;
import java.time.LocalDateTime;

public class Order {
	// private int orderID;
	private LocalDateTime createdAt;
	private ArrayList<ItemOrder> itemOrder = new ArrayList<ItemOrder>();
	private Staff created_by;
	private Customer customer;

	public Order(Staff staff, Customer customer){
		this.createdAt = LocalDateTime.now();  
		this.created_by = staff;
		this.customer = customer;
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

	public void printOrder(){
		int counter = 0;
		for(ItemOrder i : itemOrder){
			System.out.println(counter + "\t" + i.getItem().getName() + "\t" + i.getQuantity());
			counter++;
		}
	}

	public void printOrderWithSubtotal(){
		for(ItemOrder i : itemOrder){
			System.out.println(i.getItem().getName() + "\t" + i.getQuantity() + "\t" + i.calculateSubtotal());
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
}