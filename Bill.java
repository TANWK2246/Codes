public class Bill {
	private int billID;
	public Customer customer;

	public Bill(int billID, Customer customer){
		this.billID = billID;
		this.customer = customer;
	}

	public void printOrderInvoice() {
		double total, GST, ServiceCharge, discount, totalAfterDiscount, finalTotal;
		System.out.println("Light and Sword");
		System.out.println("123, Orchard Street, 123456 Singapore");
		System.out.println("=============================================");

		System.out.println("Table No.: "+this.customer.getTable().getTableID());
		System.out.println("Staff ID: "+this.customer.getOrder().getCreated_by().getStaffID());
		System.out.println("Bill ID: "+this.billID);

		this.customer.getOrder().printOrderWithSubtotal();

		total = this.customer.getOrder().calculateInitialTotalPrice();

		System.out.println("Subtotal: " + total);

		discount = this.calculateAndPrintDiscount(total, this.customer);

		totalAfterDiscount = total - discount;

		GST = this.calculateAndPrintGST(totalAfterDiscount);
		ServiceCharge = this.calculateAndPrintServiceCharge(totalAfterDiscount);
		

		finalTotal = totalAfterDiscount + GST + ServiceCharge;
		System.out.println("Total due: $" + finalTotal);

		System.out.println("=============================================");
		System.out.println("Thank you for dining with us!");
		System.out.println("=============================================");
	}

	private double calculateAndPrintServiceCharge(double amount){
		double ServiceCharge = Math.round(amount * 0.10 * 100) / 100.0;
		System.out.println("10% Service Charge: " + ServiceCharge);
		return ServiceCharge;
	}

	private double calculateAndPrintGST(double amount){
		double GST = Math.round(amount * 0.07 * 100) / 100.0;
		System.out.println("7% GST: " + GST);
		return GST;
	}

	private double calculateAndPrintDiscount(double amount, Customer customer){
		if(customer.isHasMembership() == false) return 0;
		else{
			double discount = Math.round(amount * 0.15 * 100) / 100.0;
			System.out.println("Membership Discount: -" + discount);
			return discount;
		}
	}

	
}