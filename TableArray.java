import java.io.Serializable;
import java.util.ArrayList;

public class TableArray implements Serializable{
    private ArrayList<Table> tables = new ArrayList<Table>();
    
    public TableArray(){}

    public void loadTable(){
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

    public Table getTable(int tableID){
        return this.tables.get(tableID);
    }

    public void showEmptyTables() {
        StringAlignUtils util = new StringAlignUtils(30, StringAlignUtils.Alignment.CENTER);
    	System.out.print( util.format("Empty Tables") );
        
        int counter = 0, noOfEmptyTables = 0;
		for (Table i : this.tables) {
            if(i.getIsOccupied() == false){
                System.out.printf("TableID: %d\t", counter);
                System.out.println("Capacity: " + i.getTableCapacity());
                noOfEmptyTables++;
            }
			counter++;
		}
        if(noOfEmptyTables == 0){
            System.out.println("All tables are occupied!");
        }
	}

    public int findAnEmptyTable(int noOfPax) {
		for (Table i : this.tables) {
            if(i.getTableCapacity() == noOfPax & i.getIsOccupied() == false) return i.getTableID();
		}
        return -1;
	}
}
