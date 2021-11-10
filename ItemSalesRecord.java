import java.util.ArrayList;
import java.io.Serializable;

public class ItemSalesRecord implements Serializable{
    private MenuItem menuItem;
    private ArrayList<DayQuantityPair> records = new ArrayList<DayQuantityPair>();

    public ItemSalesRecord(){}

}