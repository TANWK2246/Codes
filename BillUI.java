import java.util.Scanner;

/**
 * The type Bill ui.
 */
public class BillUI{
    /**
     * Bill generator ui. Prompt for a Table ID with order created, Ask for customer's membership and generate bill.
     *
     * @param restaurant the restaurant
     */
	public static void billGenerator(Restaurant restaurant) {
		Scanner sc = new Scanner(System.in);
        int tableID, membership;

        tableID = OrderUI.promptForWithOrderTableIDInput(restaurant.getTableArray());
        if(tableID == -1){
            System.out.println("Going back to home page...");
            
			return;
        }

		System.out.println("Do you have membership card? (1) Yes (2) No (-1) Back to Home Page");
		membership = sc.nextInt();
        if(membership == -1){
            System.out.println("Going back to home page...");
            
			return;
        }

		BillManager.generateBill(tableID, membership, restaurant.getTableArray(), restaurant.getBillArray(), restaurant.getSalesRevenueReport());
        
	}
}