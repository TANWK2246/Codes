import java.io.Serializable;

public class Restaurant implements Serializable{
	private Menu menu = new Menu();
	private TableArray tableArray = new TableArray();
	private StaffArray staffArray = new StaffArray();
	private CustomerArray customerArray = new CustomerArray();
	private BillArray billArray = new BillArray();
	private ReservationArray reservationArray = new ReservationArray();
	private SalesRevenueReport report = new SalesRevenueReport();

	public Restaurant(){}

	public Menu getMenu(){
		return menu;
	}

	public TableArray getTableArray(){
		return this.tableArray;
	}

	public StaffArray getStaffArray(){
		return this.staffArray;
	}

	public CustomerArray getCustomerArray(){
		return this.customerArray;
	}

	public ReservationArray getReservationArray() {
		return this.reservationArray;
	}

	public BillArray getBillArray() {
		return this.billArray;
	}

	public SalesRevenueReport getSalesRevenueReport() {
		return this.report;
	}
}