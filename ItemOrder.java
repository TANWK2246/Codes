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

	public double calculateSubtotal() {
		throw new UnsupportedOperationException();
	}
}