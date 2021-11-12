import java.time.LocalDate;
import java.util.Scanner;

public class ReportUI{
    public static void reportViewer(Restaurant restaurant){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter start date: (YYYY-MM-DD)");
        String start = sc.nextLine();
		LocalDate startDate = LocalDate.parse(start);

        System.out.println("Enter end date: (YYYY-MM-DD)");
        String end = sc.nextLine();
		LocalDate endDate = LocalDate.parse(end);

        System.out.println("Sales Revenue Report from " + startDate + " to " + endDate);

        ReportManager.printSalesRevenueReport(startDate, endDate, restaurant.getBillArray(), restaurant.getSalesRevenueReport());
        
    }
}
