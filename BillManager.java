import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class BillManager implements Serializable{
	private ArrayList<Bill> bills = new ArrayList<Bill>();

	public BillManager() {}

	public void generateBill(TableManager tableManager, SalesRevenueReport salesRevenueReport) {
		Scanner sc = new Scanner(System.in);
        int tableID, membership;
		Customer customer;
		Bill newBill;

        System.out.println("Enter table ID:");
		tableID = sc.nextInt();

		customer = tableManager.getTable(tableID).getCustomer();

		System.out.println("Do you have membership card? (1) Yes (2) No");
		membership = sc.nextInt();
		if(membership == 1){
			customer.setHasMembership(true);
		}else if(membership == 2){
			customer.setHasMembership(false);
		}

		newBill = new Bill(bills.size(),customer);
		bills.add(newBill);

		newBill.printOrderInvoice();

		tableManager.releaseATable(tableID);

		salesRevenueReport.updateRecord(newBill);
	}

	public ArrayList<Bill> getBills(){
		return this.bills;
	}
	
}