import java.io.Serializable;

/**
 * The type Customer.
 */
public class Customer implements Serializable{
	/**
	 * The Name.
	 */
	private String name;
	/**
	 * The No of pax.
	 */
	private int noOfPax;
	/**
	 * The Has membership.
	 */
	private boolean hasMembership;
	/**
	 * The Phone.
	 */
	private int phone;
	/**
	 * The Order.
	 */
	private Order order;
	/**
	 * The Table.
	 */
	private Table table;

	/**
	 * Instantiates a new Customer.
	 */
	public Customer(){}

	/**
	 * Instantiates a new Customer.
	 *
	 * @param name    the name
	 * @param noOfPax the no of pax
	 * @param table   the table
	 * @param phone   the phone
	 */
	public Customer(String name, int noOfPax, Table table, int phone) {
		this.name = name;
		this.noOfPax = noOfPax;
		this.table = table;
		this.phone = phone;
	}

	/**
	 * Instantiates a new Customer.
	 *
	 * @param name    the name
	 * @param noOfPax the no of pax
	 * @param table   the table
	 */
	public Customer(String name, int noOfPax, Table table) {
		this.name = name;
		this.noOfPax = noOfPax;
		this.table = table;
	}
	
	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Is has membership boolean.
	 *
	 * @return the boolean
	 */
	public boolean isHasMembership() {
		return this.hasMembership;
	}

	/**
	 * Sets has membership.
	 *
	 * @param hasMembership the has membership
	 */
	public void setHasMembership(boolean hasMembership) {
		this.hasMembership = hasMembership;
	}

	/**
	 * Sets phone.
	 *
	 * @param phone the phone
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * Gets order.
	 *
	 * @return the order
	 */
	public Order getOrder() {
		return this.order;
	}

	/**
	 * Sets order.
	 *
	 * @param order the order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Gets table.
	 *
	 * @return the table
	 */
	public Table getTable() {
		return this.table;
	}

	/**
	 * Gets no of pax.
	 *
	 * @return the no of pax
	 */
	public int getNoOfPax() {
		return this.noOfPax;
	}

	/**
	 * Gets phone.
	 *
	 * @return the phone
	 */
	public int getPhone() {
		return this.phone;
	}


}