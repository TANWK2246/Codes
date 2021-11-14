import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Table array. It stores an array list which stores all the table objects.
 */
public class TableArray implements Serializable{
    /**
     * The Tables.
     */
    private ArrayList<Table> tables = new ArrayList<Table>();
    
    /**
     * Instantiates a new Table array.
     */
    public TableArray(){}

    /**
     * Load table.
     */
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


    /**
     * Show empty tables.
     */
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

	/**
	 * Gets the array list of tables.
	 *
	 * @return the array list of tables.
	 */
    public ArrayList<Table> getTables(){
        return this.tables;
    }

}
