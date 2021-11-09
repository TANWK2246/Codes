public class ItemOrder {
	private int quantity;
	private MenuItem item;

	
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

	public void setItem(MenuItem item) {
		this.item = item;
	}

	public double calculateSubtotal() {
		return this.item.getPrice() * this.quantity;
	}
}