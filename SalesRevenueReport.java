import java.util.ArrayList;
import java.io.Serializable;

public class SalesRevenueReport implements Serializable{
    private ArrayList<ItemSalesRecord> records = new ArrayList<ItemSalesRecord>();
    
    public SalesRevenueReport(){}
}
