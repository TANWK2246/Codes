import java.time.LocalDate;

public class ReportManager{
    public static void updateRecord(Bill bill, SalesRevenueReport report){
        for(ItemOrder item : bill.getCustomer().getOrder().getItemOrder()){
            for(ItemSalesRecord record : report.getRecords()){
                if(item.getItem().equals(record.getMenuItem())){
                    record.addPair(new DayQuantityPair(bill.getCheckOutTime().toLocalDate(), item.getQuantity()));
                    break;
                }
            }
            ItemSalesRecord newItemSalesRecord = new ItemSalesRecord(item.getItem());
            report.getRecords().add(newItemSalesRecord);
            newItemSalesRecord.addPair(new DayQuantityPair(bill.getCheckOutTime().toLocalDate(), item.getQuantity()));
            
        }
    }

    public static void printSalesRevenueReport(LocalDate startDate, LocalDate endDate, Restaurant restaurant){
        System.out.println("Sales Revenue Report from " + startDate + " to " + endDate);

        double totalSales = 0;

        for(ItemSalesRecord record : restaurant.getSalesRevenueReport().getRecords()){
            totalSales += record.printRecord(startDate, endDate);
        }

        System.out.println("Total Sales: " + totalSales);

        double totalDiscount = 0, totalGST = 0, totalServiceCharge = 0;

        for(Bill bill : restaurant.getBillArray().getBills()){
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
