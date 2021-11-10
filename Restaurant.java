import java.io.Serializable;

public class Restaurant implements Serializable{
	private TableManager tableManager = new TableManager();
	private Menu menu = new Menu();
	private StaffManager staffManager = new StaffManager();
	private CustomerManager customerManager = new CustomerManager();
	private OrderManager orderManager = new OrderManager();
	private ReservationManager reservationManager = new ReservationManager();
	private BillManager billManager = new BillManager();
	
	private SalesRevenueReport report = new SalesRevenueReport();

	public Restaurant(){}

	public Menu getMenu(){
		return this.menu;
	}

	public TableManager getTableManager(){
		return this.tableManager;
	}

	public StaffManager getStaffManager(){
		return this.staffManager;
	}

	public CustomerManager getCustomerManager(){
		return this.customerManager;
	}

	public ReservationManager getReservationManager() {
		return this.reservationManager;
	}

	public BillManager getBillManager() {
		return this.billManager;
	}

	public OrderManager getOrderManager() {
		return this.orderManager;
	}

	public SalesRevenueReport getSalesRevenueReport() {
		return this.report;
	}
}