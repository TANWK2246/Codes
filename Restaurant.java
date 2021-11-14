import java.io.Serializable;

/**
 * The type Restaurant.
 */
public class Restaurant implements Serializable{
	/**
	 * The Menu.
	 */
	private Menu menu = new Menu();
	/**
	 * The Table array.
	 */
	private TableArray tableArray = new TableArray();
	/**
	 * The Staff array.
	 */
	private StaffArray staffArray = new StaffArray();
	/**
	 * The Customer array.
	 */
	private CustomerArray customerArray = new CustomerArray();
	/**
	 * The Bill array.
	 */
	private BillArray billArray = new BillArray();
	/**
	 * The Reservation array.
	 */
	private ReservationArray reservationArray = new ReservationArray();
	/**
	 * The Report.
	 */
	private SalesRevenueReport report = new SalesRevenueReport();

	/**
	 * Instantiates a new Restaurant.
	 */
	public Restaurant(){}

	/**
	 * Get menu menu.
	 *
	 * @return the menu
	 */
	public Menu getMenu(){
		return menu;
	}

	/**
	 * Get table array table array.
	 *
	 * @return the table array
	 */
	public TableArray getTableArray(){
		return this.tableArray;
	}

	/**
	 * Get staff array staff array.
	 *
	 * @return the staff array
	 */
	public StaffArray getStaffArray(){
		return this.staffArray;
	}

	/**
	 * Get customer array customer array.
	 *
	 * @return the customer array
	 */
	public CustomerArray getCustomerArray(){
		return this.customerArray;
	}

	/**
	 * Gets reservation array.
	 *
	 * @return the reservation array
	 */
	public ReservationArray getReservationArray() {
		return this.reservationArray;
	}

	/**
	 * Gets bill array.
	 *
	 * @return the bill array
	 */
	public BillArray getBillArray() {
		return this.billArray;
	}

	/**
	 * Gets sales revenue report.
	 *
	 * @return the sales revenue report
	 */
	public SalesRevenueReport getSalesRevenueReport() {
		return this.report;
	}
}