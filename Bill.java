import java.time.LocalDateTime;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Bill implements Serializable{
	private int billID;
	private LocalDateTime checkOutTime;
	private Customer customer;
	private double discount;
	private double serviceCharge;
	private double GST;

	public Bill(){}

	public Bill(int billID, Customer customer){
		this.billID = billID;
		this.customer = customer;
		this.checkOutTime = LocalDateTime.now();

		this.discount = DiscountCalculator.calculate(this.customer.getOrder().calculateInitialTotalPrice(), this.customer.isHasMembership());
		this.serviceCharge = ServiceChargeCalculator.calculate(this.customer.getOrder().calculateInitialTotalPrice() - this.discount);
		this.GST = GSTCalculator.calculate(this.customer.getOrder().calculateInitialTotalPrice() - this.discount);
	}

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
	
	public double getDiscount() {
		return this.discount;
	}

	public double getServiceCharge() {
		return this.serviceCharge;
	}

	public double getGST() {
		return this.GST;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public LocalDateTime getCheckOutTime() {
		return this.checkOutTime;
	}
}