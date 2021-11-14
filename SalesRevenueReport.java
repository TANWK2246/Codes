import java.util.ArrayList;
import java.io.Serializable;

/**
 * The type Sales revenue report.
 */
public class SalesRevenueReport implements Serializable{
    /**
     * The Records.
     */
    private ArrayList<ItemSalesRecord> records = new ArrayList<ItemSalesRecord>();

    /**
     * Get records array list.
     *
     * @return the array list
     */
    public ArrayList<ItemSalesRecord> getRecords(){
        return this.records;
    }

}
