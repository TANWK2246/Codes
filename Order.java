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
}