import java.util.Scanner;

public class App{
    public static void main(String[] args)
    {
        int choice;
        Scanner sc = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        do{
            System.out.println("Perform the following methods:");
            System.out.println("1: Display Menu");
            System.out.println("2: Edit Menu");
            System.out.println("3: Display Empty Tables");
            System.out.println("4: Assign New Customer");
            System.out.println("5: Create Order");
            System.out.println("6: View/Edit/Remove Order");
            System.out.println("7: Create Reservation Booking");
            System.out.println("8: Check/Remove Reservation Booking");
            System.out.println("9: Make Payment / Print Order Invoice");
            System.out.println("10: Print Sales Revenue Report");
            System.out.println("11: Terminate the Programme");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    restaurant.getMenu().displayMenu();
                    break;
                case 2: 
                    restaurant.getMenu().editMenu();
                    break;
                case 3:
                    restaurant.getTableManager().showEmptyTables();
                    break;
                case 4: 
                    restaurant.getCustomerManager().assignNewCustomerToTable(restaurant.getTableManager());
                    break;
                case 5:
                    restaurant.getOrderManager().createOrder(restaurant.getTableManager(), restaurant.getStaffManager(), restaurant.getMenu());
                    break;
                case 6:
                    restaurant.getOrderManager().viewOrder(restaurant.getTableManager());
                    break;
                case 7:
                    break;
                case 8:
                    break;

                case 9:
                    restaurant.getBillManager().generateBill(restaurant.getTableManager());
                    break;
                case 10:
                    break;

                case 11: System.out.println("Program terminating...");
            }

        }while (choice < 11);

    }
}