import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class SalesRevenueReport implements Serializable{
    private ArrayList<ItemSalesRecord> records = new ArrayList<ItemSalesRecord>();    

    public void updateRecord(Bill bill){
        for(ItemOrder item : bill.getCustomer().getOrder().getItemOrder()){
            for(ItemSalesRecord record : records){
                if(item.getItem().equals(record.getMenuItem())){
                    record.addPair(new DayQuantityPair(bill.getCheckOutTime().toLocalDate(), item.getQuantity()));
                    break;
                }
            }
            ItemSalesRecord newItemSalesRecord = new ItemSalesRecord(item.getItem());
            this.records.add(newItemSalesRecord);
            newItemSalesRecord.addPair(new DayQuantityPair(bill.getCheckOutTime().toLocalDate(), item.getQuantity()));
            
        }
    }

    public void printSalesRevenueReport(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start date: (YYYY-MM-DD)");
        String start = sc.nextLine();
		LocalDate startDate = LocalDate.parse(start);

        System.out.println("Enter end date: (YYYY-MM-DD)");
        String end = sc.nextLine();
		LocalDate endDate = LocalDate.parse(end);

        System.out.println("Sales Revenue Report from " + startDate + " to " + endDate);

        for(ItemSalesRecord record : records){
            record.printRecord(startDate, endDate);
        }

        System.out.println("========================================================");
    }
}
