import java.time.LocalDateTime;
import java.io.Serializable;

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
		System.out.println("Light and Sword");
		System.out.println("123, Orchard Street, 123456 Singapore");
		System.out.println("=============================================");

		System.out.println("Table No.: "+this.customer.getTable().getTableID());
		System.out.println("Staff ID: "+this.customer.getOrder().getCreated_by().getStaffID());
		System.out.println("Bill ID: "+this.billID);
		System.out.println(this.checkOutTime);

		this.customer.getOrder().printOrderWithSubtotal();

		System.out.println("Subtotal: " + this.customer.getOrder().calculateInitialTotalPrice());
		System.out.println("Membership Discount: " + this.discount);
		System.out.println("Service Charge (10%): " + this.serviceCharge);
		System.out.println("GST (7%): " + this.GST);

		finalTotal = this.customer.getOrder().calculateInitialTotalPrice() - this.discount + this.GST + this.serviceCharge;
		finalTotal = Math.round(finalTotal * 100) / 100.0;
		System.out.println("Total due: $" + finalTotal);

		System.out.println("=============================================");
		System.out.println("Thank you for dining with us!");
		System.out.println("=============================================");
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