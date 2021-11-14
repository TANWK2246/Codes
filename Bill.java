import java.time.LocalDateTime;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

/**
 * The type Bill.
 */
public class Bill implements Serializable{
	/**
	 * The Bill id.
	 */
	private int billID;
	/**
	 * The Check out time.
	 */
	private LocalDateTime checkOutTime;
	/**
	 * The Customer.
	 */
	private Customer customer;
	/**
	 * The Discount.
	 */
	private double discount;
	/**
	 * The Service charge.
	 */
	private double serviceCharge;
	/**
	 * The Gst.
	 */
	private double GST;

	/**
	 * Instantiates a new Bill.
	 */
	public Bill(){}

	/**
	 * Instantiates a new Bill.
	 *
	 * @param billID   the bill id
	 * @param customer the customer
	 */
	public Bill(int billID, Customer customer){
		this.billID = billID;
		this.customer = customer;
		this.checkOutTime = LocalDateTime.now();

		this.discount = DiscountCalculator.calculate(this.customer.getOrder().calculateInitialTotalPrice(), this.customer.isHasMembership());
		this.serviceCharge = ServiceChargeCalculator.calculate(this.customer.getOrder().calculateInitialTotalPrice() - this.discount);
		this.GST = GSTCalculator.calculate(this.customer.getOrder().calculateInitialTotalPrice() - this.discount);
	}

	/**
	 * Print order invoice.
	 */
	public void printOrderInvoice() {
		double finalTotal;
		
		StringAlignUtils util = new StringAlignUtils(42, StringAlignUtils.Alignment.CENTER);
    	System.out.print( util.format("Whatever Cafe") );
		System.out.print( util.format("123, Orchard Street, 123456 Singapore") );
		System.out.println("==========================================");

		System.out.println("Table No.:\t"+this.customer.getTable().getTableID());
		System.out.println("Waiter ID:\t"+this.customer.getOrder().getCreated_by().getStaffID());
		System.out.println("Bill ID:\t"+this.billID);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Date Time:\t" + this.checkOutTime.format(formatter));
		System.out.println("------------------------------------------");

		this.customer.getOrder().printOrderWithSubtotal();
		System.out.println("------------------------------------------");

		System.out.printf("    Subtotal:\t\t\tS$ %7.2f\n", this.customer.getOrder().calculateInitialTotalPrice());
		if(this.discount != 0){
			System.out.printf("    Membership Discount:\tS$ %7.2f\n", this.discount);
		}
		System.out.printf("    Service Charge (10%%):\tS$ %7.2f\n", this.serviceCharge);
		System.out.printf("    GST (7%%):\t\t\tS$ %7.2f\n", this.GST);
		System.out.println("------------------------------------------");

		finalTotal = this.customer.getOrder().calculateInitialTotalPrice() - this.discount + this.GST + this.serviceCharge;
		finalTotal = Math.round(finalTotal * 100) / 100.0;
		System.out.printf("    Total due:\t\t\tS$ %7.2f\n", finalTotal);

		System.out.println("==========================================");
		System.out.print( util.format("Thank you for dining with us!") );
		System.out.println("==========================================");
	}
	
	/**
	 * Gets discount.
	 *
	 * @return the discount
	 */
	public double getDiscount() {
		return this.discount;
	}

	/**
	 * Gets service charge.
	 *
	 * @return the service charge
	 */
	public double getServiceCharge() {
		return this.serviceCharge;
	}

	/**
	 * Gets gst.
	 *
	 * @return the gst
	 */
	public double getGST() {
		return this.GST;
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
	 * Gets check out time.
	 *
	 * @return the check out time
	 */
	public LocalDateTime getCheckOutTime() {
		return this.checkOutTime;
	}
}