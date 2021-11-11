import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;

public class ItemSalesRecord implements Serializable{
    private MenuItem menuItem;
    private ArrayList<DayQuantityPair> records = new ArrayList<DayQuantityPair>();

    public ItemSalesRecord(){}

    public ItemSalesRecord(MenuItem menuItem){
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return this.menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
    
    public void addPair(DayQuantityPair pair){
        this.records.add(pair);
    }

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