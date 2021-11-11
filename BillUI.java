import java.util.Scanner;

public class BillUI{
	public static void BillGenerator(Restaurant restaurant) {
		Scanner sc = new Scanner(System.in);
        int tableID, membership;

        System.out.println("Enter table ID:");
		tableID = sc.nextInt();
        while(TableManager.validateCustomerAtTable(tableID, restaurant.getTableArray()) == false){
            System.out.println("The table is empty");
            System.out.println("Enter table ID:");
            tableID = sc.nextInt();
        }
        while(TableManager.validateOrderExists(tableID, restaurant.getTableArray()) == false){
            System.out.println("The table has no order yet");
            System.out.println("Enter table ID:");
            tableID = sc.nextInt();
        }

		System.out.println("Do you have membership card? (1) Yes (2) No");
		membership = sc.nextInt();

		BillManager.generateBill(tableID, membership, restaurant);
		
	}
}