import java.time.LocalDate;
import java.util.Scanner;

public class ReportUI{
    public static void reportViewer(Restaurant restaurant){
        Scanner sc = new Scanner(System.in);
        System.out.println("View Sales Revenue Report");
        System.out.println("From:");
		LocalDate startDate = promptForDateInput();

        System.out.println("To:");
		LocalDate endDate = promptForDateInput();

        ReportManager.printSalesRevenueReport(startDate, endDate, restaurant.getBillArray(), restaurant.getSalesRevenueReport());
    }

    public static LocalDate promptForDateInput(){
        Scanner sc = new Scanner(System.in);
		String input;
        LocalDate dateInput;

		while(true){
			try{
				System.out.println("Enter date: (YYYY-MM-DD)");
				input = sc.nextLine();
                dateInput = LocalDate.parse(input);
				break;
			}catch (Exception e){
				System.out.println("Invalid date format. Please enter again!");
			}
		}
		return dateInput;
    }
}
