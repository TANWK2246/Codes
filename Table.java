import java.io.Serializable;

/**
 * The type Table.
 */
public class Table implements Serializable{
	/**
	 * The Table id.
	 */
	private int tableID;
	/**
	 * The Table capacity.
	 */
	private int tableCapacity;
	/**
	 * The Is occupied.
	 */
	private boolean isOccupied;
	/**
	 * The Customer.
	 */
	private Customer customer;

	/**
	 * Instantiates a new Table.
	 */
	public Table(){}

	/**
	 * Instantiates a new Table.
	 *
	 * @param tableID       the table id
	 * @param tableCapacity the table capacity
	 */
	public Table(int tableID, int tableCapacity){
		this.tableID = tableID;
		this.tableCapacity = tableCapacity;
		this.isOccupied = false;
	}

	/**
	 * Gets table id.
	 *
	 * @return the table id
	 */
	public int getTableID(){
		return this.tableID;
	}

	/**
	 * Gets table capacity.
	 *
	 * @return the table capacity
	 */
	public int getTableCapacity() {
		return this.tableCapacity;
	}

	/**
	 * Sets table capacity.
	 *
	 * @param tableCapacity the table capacity
	 */
	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}

	/**
	 * Gets is occupied.
	 *
	 * @return if is occupied
	 */
	public boolean getIsOccupied() {
		return this.isOccupied;
	}

	/**
	 * Sets is occupied.
	 *
	 * @param isOccupied if is occupied
	 */
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	/**
	 * Gets customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * Set customer.
	 *
	 * @param customer the customer
	 */
	public void setCustomer(Customer customer){
		this.customer = customer;
	}

}