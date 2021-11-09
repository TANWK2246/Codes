import java.util.ArrayList;

public class Restaurant {
	private TableManager tableManager = new TableManager();
	private Menu menu = new Menu();
	private StaffManager staffManager = new StaffManager();
	private CustomerManager customerManager = new CustomerManager();
	private ReservationManager reservationManager = new ReservationManager();
	private BillManager billManager = new BillManager();
	private OrderManager orderManager = new OrderManager();
	
	

	public void generateBill(int tableID) {
		throw new UnsupportedOperationException();
	}

	public void printSalesRevenueReport() {
		throw new UnsupportedOperationException();
	}

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


}