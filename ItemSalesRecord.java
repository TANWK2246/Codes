import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The type Item sales record.
 */
public class ItemSalesRecord implements Serializable{
    /**
     * The Menu item.
     */
    private MenuItem menuItem;
    /**
     * The Records.
     */
    private ArrayList<DayQuantityPair> records = new ArrayList<DayQuantityPair>();

    
    /**
     * Instantiates a new Item sales record.
     */
    public ItemSalesRecord(){}

    /**
     * Instantiates a new Item sales record.
     *
     * @param menuItem the menu item
     */
    public ItemSalesRecord(MenuItem menuItem){
        this.menuItem = menuItem;
    }


    /**
     * Gets menu item.
     *
     * @return the menu item
     */
    public MenuItem getMenuItem() {
        return this.menuItem;
    }

    /**
     * Sets menu item.
     *
     * @param menuItem the menu item
     */
    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    /**
     * Add pair.
     *
     * @param pair the pair
     */
    public void addPair(DayQuantityPair pair){
        this.records.add(pair);
    }

    /**
     * Print record double.
     *
     * @param start the start
     * @param end   the end
     * @return the double
     */
    public double printRecord(LocalDate start, LocalDate end){
        int totalQuantity = 0;
        for(DayQuantityPair pair : records){
            if(start.compareTo(pair.getDay()) > 0) continue;
            if(end.compareTo(pair.getDay()) < 0)break;
            totalQuantity += pair.getQuantity();
        }
        System.out.println(this.menuItem.getName() + "\t" + totalQuantity + "\t" + totalQuantity*this.menuItem.getPrice());
        return totalQuantity*this.menuItem.getPrice();
    }
}