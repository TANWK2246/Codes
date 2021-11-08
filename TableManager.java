import java.util.ArrayList;

public class TableManager {
    private ArrayList<Table> tables = new ArrayList<Table>();

    public TableManager(){
        this.tables.add(new Table(this.tables.size(), 2));
        this.tables.add(new Table(this.tables.size(), 2));
        this.tables.add(new Table(this.tables.size(), 2));
        this.tables.add(new Table(this.tables.size(), 2));
        this.tables.add(new Table(this.tables.size(), 4));
        this.tables.add(new Table(this.tables.size(), 4));
        this.tables.add(new Table(this.tables.size(), 6));
        this.tables.add(new Table(this.tables.size(), 6));
        this.tables.add(new Table(this.tables.size(), 8));
        this.tables.add(new Table(this.tables.size(), 10));
    }

    public void showEmptyTables() {
        int counter = 0;
		for (Table i : tables) {
            if(i.getIsOccupied() == false){
                System.out.printf("TableID: %d\t", counter);
                System.out.println("Capacity: " + i.getTableCapacity());
            }
			counter++;
		}
	}

	public int findAnEmptyTable(int noOfPax) {
		for (Table i : tables) {
            if(i.getTableCapacity() == noOfPax & i.getIsOccupied() == false) return i.getTableID();
		}
        return -1;
	}

	public void bookATable(int tableID) {
		this.tables.get(tableID).setIsOccupied(true);
	}

	public void releaseATable(int tableID) {
		this.tables.get(tableID).setIsOccupied(false);
	}

    public Table getTable(int tableID){
        return this.tables.get(tableID);
    }
}
