import java.time.LocalDate;

public class ReportManager{
    public static void updateRecord(Bill bill, SalesRevenueReport report){
        boolean foundExistingRecord = false;
        for(ItemOrder item : bill.getCustomer().getOrder().getItemOrder()){
            foundExistingRecord = false;
            for(ItemSalesRecord record : report.getRecords()){
                if(item.getItem().getName().equals(record.getMenuItem().getName())){
                    foundExistingRecord = true;
                    record.addPair(new DayQuantityPair(bill.getCheckOutTime().toLocalDate(), item.getQuantity()));
                    break;
                }
            }
            if(foundExistingRecord == false){
                ItemSalesRecord newItemSalesRecord = new ItemSalesRecord(item.getItem());
                report.getRecords().add(newItemSalesRecord);
                newItemSalesRecord.addPair(new DayQuantityPair(bill.getCheckOutTime().toLocalDate(), item.getQuantity()));
            }
        }
    }

    public static void printSalesRevenueReport(LocalDate startDate, LocalDate endDate, BillArray billArray, SalesRevenueReport report){
        StringAlignUtils util = new StringAlignUtils(50, StringAlignUtils.Alignment.CENTER);
        System.out.println("--------------------------------------------------");
        System.out.print( util.format("Sales Revenue Report from " + startDate + " to " + endDate) );
        System.out.println("--------------------------------------------------");

        double totalSales = 0;

        String formatInfo = "%s\t%-20.20s\t%s\n";
        System.out.format(formatInfo, "Qty", "Item Name", "Sales");

        for(ItemSalesRecord record : report.getRecords()){
            totalSales += record.printRecord(startDate, endDate);
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Total Sales:\t\t\tS$ %9.2f\n", totalSales);

        double totalDiscount = 0, totalGST = 0, totalServiceCharge = 0;

        for(Bill bill : billArray.getBills()){
            if(startDate.compareTo(bill.getCheckOutTime().toLocalDate()) > 0) continue;
            if(endDate.compareTo(bill.getCheckOutTime().toLocalDate()) < 0)break;
            totalDiscount += bill.getDiscount();
            totalGST += bill.getGST();
            totalServiceCharge += bill.getServiceCharge();
        }

        System.out.printf("Total Discount given:\t\tS$ %9.2f\n", totalDiscount);
        System.out.printf("Total GST collected:\t\tS$ %9.2f\n", totalGST);
        System.out.printf("Total Service Charge collected:\tS$ %9.2f\n", totalServiceCharge);
        System.out.println();
        System.out.printf("Total Revenue:\t\t\tS$ %9.2f\n", (totalSales-totalDiscount+totalServiceCharge+totalGST));

        System.out.println("==================================================");
    }
}
