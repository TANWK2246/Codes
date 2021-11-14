import java.io.Serializable;

/**
 * The type Item order.
 */
public class ItemOrder implements Serializable{
	/**
	 * The Quantity.
	 */
	private int quantity;
	/**
	 * The Item.
	 */
	private MenuItem item;

	/**
	 * Instantiates a new Item order.
	 */
	public ItemOrder(){}
	
	/**
	 * Instantiates a new Item order.
	 *
	 * @param item     the item
	 * @param quantity the quantity
	 */
	public ItemOrder(MenuItem item, int quantity){
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * Gets quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Sets quantity.
	 *
	 * @param quantity the quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets item.
	 *
	 * @return the item
	 */
	public MenuItem getItem() {
		return this.item;
	}

	/**
	 * Calculate subtotal double.
	 *
	 * @return the double
	 */
	public double calculateSubtotal() {
		return this.item.getPrice() * this.quantity;
	}
}