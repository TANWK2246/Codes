import java.io.Serializable;

public class Customer implements Serializable{
	private String name;
	private int noOfPax;
	private boolean hasMembership;
	private int phone;
	private Order order;
	private Table table;
	private Reservation reservation;

	public Customer(){}

	public Customer(String name, int noOfPax, Table table, int phone) {
		this.name = name;
		this.noOfPax = noOfPax;
		this.table = table;
		this.phone = phone;
	}

	public Customer(String name, int noOfPax, Table table) {
		this.name = name;
		this.noOfPax = noOfPax;
		this.table = table;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfPax() {
		return this.noOfPax;
	}

	public void setNoOfPax(int noOfPax) {
		this.noOfPax = noOfPax;
	}

	public boolean isHasMembership() {
		return this.hasMembership;
	}

	public void setHasMembership(boolean hasMembership) {
		this.hasMembership = hasMembership;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Table getTable() {
		return this.table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Reservation getReservation() {
		return this.reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}