public class BillManager{
	public static void generateBill(int tableID, int membership, TableArray tableArray, BillArray billArray, SalesRevenueReport report) {
		Bill newBill;

		Customer customer = TableManager.getTable(tableID, tableArray).getCustomer();

		if(membership == 1){
			customer.setHasMembership(true);
		}else if(membership == 2){
			customer.setHasMembership(false);
		}

		newBill = new Bill(billArray.getBills().size(), customer);
		billArray.addBill(newBill);

		newBill.printOrderInvoice();

		TableManager.releaseATable(tableID, tableArray);

		ReportManager.updateRecord(newBill, report);
	}
	
}