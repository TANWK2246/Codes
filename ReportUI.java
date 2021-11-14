import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * The type Report ui.
 */
public class ReportUI{
    /**
	 * Report viewer ui.
	 *
	 * @param restaurant the restaurant
	 */
	public static void reportViewer(Restaurant restaurant){
        Scanner sc = new Scanner(System.in);
        System.out.println("View Sales Revenue Report");
        System.out.println("From:");
		LocalDate startDate = promptForDateInput();

        System.out.println("To:");
		LocalDate endDate = promptForDateInput();

        ReportManager.printSalesRevenueReport(startDate, endDate, restaurant.getBillArray(), restaurant.getSalesRevenueReport());
    }

	/**
	 * Prompt for date input local date.
	 *
	 * @return the local date input
	 */
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
			}catch (DateTimeParseException e){
				System.out.println("Invalid date format. Please enter again!");
			}
		}
		return dateInput;
    }
}
