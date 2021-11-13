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

        if(totalQuantity == 0){
            return 0;
        }

        String formatInfo = "%d\t%-20.20s\tS$ %9.2f\n";
        System.out.format(formatInfo, totalQuantity, this.menuItem.getName(), totalQuantity*this.menuItem.getPrice());
        return totalQuantity*this.menuItem.getPrice();
    }
}