/**
 * The type Table manager.
 */

public class TableManager {
	/**
     * Find an empty table based on noOfPax.
     *
     * @param noOfPax the no of pax
	 * @param tableArray the table array
     * @return the tableID of the empty table found or -1 if no suitable table is found
     */
    public static int findAnEmptyTable(int noOfPax, TableArray tableArray) {
		if(noOfPax % 2 == 1){noOfPax++;}
		for (Table i : tableArray.getTables()) {
            if(i.getTableCapacity() == noOfPax & i.getIsOccupied() == false) return i.getTableID();
		}
        return -1;
	}

	/**
	 * Book a table by setting the table to be occupied.
	 *
	 * @param tableID    the table id
	 * @param tableArray the table array
	 */
	public static void bookATable(int tableID, TableArray tableArray) {
		tableArray.getTables().get(tableID).setIsOccupied(true);
	}

	/**
	 * Release a table by setting the table to be not occupied.
	 *
	 * @param tableID    the table id
	 * @param tableArray the table array
	 */
	public static void releaseATable(int tableID, TableArray tableArray) {
		tableArray.getTables().get(tableID).setIsOccupied(false);
	}

	/**
	 * Validate if there is a customer at table.
	 *
	 * @param tableID    the table id
	 * @param tableArray the table array
	 * @return true if there is a customer at table, false otherwise
	 */
	public static boolean validateCustomerAtTable(int tableID, TableArray tableArray){
		return tableArray.getTables().get(tableID).getIsOccupied();
	}

	/**
	 * Validate if there is an order already created for the customer at table.
	 *
	 * @param tableID    the table id
	 * @param tableArray the table array
	 * @return true if the customer at the table had created an order, false otherwise
	 */
	public static boolean validateOrderExists(int tableID, TableArray tableArray){
		if(tableArray.getTables().get(tableID).getCustomer().getOrder() == null) return false;
		return true;
	}

}
