import java.io.Serializable;

public class ItemOrder implements Serializable{
	private int quantity;
	private MenuItem item;

	public ItemOrder(){}
	
	public ItemOrder(MenuItem item, int quantity){
		this.item = item;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MenuItem getItem() {
		return this.item;
	}

	public double calculateSubtotal() {
		return this.item.getPrice() * this.quantity;
	}
}