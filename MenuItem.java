import java.io.Serializable;

/**
 * The type Menu item.
 */
public abstract class MenuItem implements Serializable{
	/**
	 * The Name.
	 */
	private String name;
	/**
	 * The Description.
	 */
	private String description;
	/**
	 * The Price.
	 */
	private double price;

	/**
	 * Instantiates a new Menu item.
	 */
	public MenuItem(){}

	/**
	 * Instantiates a new Menu item.
	 *
	 * @param name        the name
	 * @param description the description
	 * @param price       the price
	 */
	public MenuItem(String name, String description, double price){
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/**
	 * Display menu item.
	 */
	public abstract void displayMenuItem();

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Sets price.
	 *
	 * @param price the price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}