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

    public void printSalesRevenueReport(ArrayList<Bill> bills){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start date: (YYYY-MM-DD)");
        String start = sc.nextLine();
		LocalDate startDate = LocalDate.parse(start);

        System.out.println("Enter end date: (YYYY-MM-DD)");
        String end = sc.nextLine();
		LocalDate endDate = LocalDate.parse(end);

        System.out.println("Sales Revenue Report from " + startDate + " to " + endDate);

        double totalSales = 0;

        for(ItemSalesRecord record : records){
            totalSales += record.printRecord(startDate, endDate);
        }

        System.out.println("Total Sales: " + totalSales);

        double totalDiscount = 0, totalGST = 0, totalServiceCharge = 0;

        for(Bill bill : bills){
            if(startDate.compareTo(bill.getCheckOutTime().toLocalDate()) > 0) continue;
            if(endDate.compareTo(bill.getCheckOutTime().toLocalDate()) < 0)break;
            totalDiscount += bill.getDiscount();
            totalGST += bill.getGST();
            totalServiceCharge += bill.getServiceCharge();
        }

        System.out.println("Total Discount given: - " + totalDiscount);
        System.out.println("Total GST collected: " + totalGST);
        System.out.println("Total Service Charge collected: " + totalServiceCharge);
        System.out.println();
        System.out.println("Total Revenue: " + (totalSales-totalDiscount+totalServiceCharge+totalGST));

        System.out.println("========================================================");
    }
}
