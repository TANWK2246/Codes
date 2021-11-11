public class TableManager {
	public static int tableFinder(int noOfPax, TableArray tableArray) {
        if(noOfPax % 2 == 1){noOfPax++;}
		return tableArray.findAnEmptyTable(noOfPax);
	}

	public static void bookATable(int tableID, TableArray tableArray) {
		tableArray.getTable(tableID).setIsOccupied(true);
	}

	public static void releaseATable(int tableID, TableArray tableArray) {
		tableArray.getTable(tableID).setIsOccupied(false);
	}

	public static boolean validateCustomerAtTable(int tableID, TableArray tableArray){
		return tableArray.getTable(tableID).getIsOccupied();
	}

	public static Table getTable(int tableID, TableArray tableArray){
		return tableArray.getTable(tableID);
	}

	public static boolean validateOrderExists(int tableID, TableArray tableArray){
		return tableArray.getTable(tableID).hasOrder();
	}

}
