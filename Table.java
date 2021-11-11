import java.io.Serializable;

public class Table implements Serializable{
	private int tableID;
	private int tableCapacity;
	private boolean isOccupied;
	private Customer customer;

	public Table(){}

	public Table(int tableID, int tableCapacity){
		this.tableID = tableID;
		this.tableCapacity = tableCapacity;
		this.isOccupied = false;
	}

	public int getTableID(){
		return this.tableID;
	}

	public int getTableCapacity() {
		return this.tableCapacity;
	}

	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}

	public boolean getIsOccupied() {
		return this.isOccupied;
	}

	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	public boolean hasOrder(){
		if(this.customer.getOrder() == null)return false;
		return true;
	}
}