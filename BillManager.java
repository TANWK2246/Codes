/**
 * The type Bill manager.
 */

public class BillManager{
	/**
	 * Generate bill, release table, update sales record.
	 *
	 * @param tableID    the table id
	 * @param membership the membership (1 for has membership, 2 for has no membership)
	 * @param tableArray the table array
	 * @param billArray  the bill array
	 * @param report     the report
	 */
	public static void generateBill(int tableID, int membership, TableArray tableArray, BillArray billArray, SalesRevenueReport report) {
		Bill newBill;

		Customer customer = tableArray.getTables().get(tableID).getCustomer();

		if(membership == 1){
			customer.setHasMembership(true);
		}else if(membership == 2){
			customer.setHasMembership(false);
		}

		newBill = new Bill(billArray.getBills().size(), customer);
		billArray.getBills().add(newBill);

		newBill.printOrderInvoice();

		TableManager.releaseATable(tableID, tableArray);

		ReportManager.updateRecord(newBill, report);
	}
	
}