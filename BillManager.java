import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class BillManager{
	public static void generateBill(int tableID, int membership, Restaurant restaurant) {
		Bill newBill;

		Customer customer = TableManager.getTable(tableID, restaurant.getTableArray()).getCustomer();

		if(membership == 1){
			customer.setHasMembership(true);
		}else if(membership == 2){
			customer.setHasMembership(false);
		}

		newBill = new Bill(restaurant.getBillArray().getBills().size(), customer);
		restaurant.getBillArray().addBill(newBill);

		newBill.printOrderInvoice();

		TableManager.releaseATable(tableID, restaurant.getTableArray());

		// salesRevenueReport.updateRecord(newBill);
	}
	
}