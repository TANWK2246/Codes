import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Testing{

	public static void main(String[] args)
    {
        Restaurant restaurant = new Restaurant();
        int choice;
        Scanner sc = new Scanner(System.in);

        restaurant.getTableManager().loadTable();
        restaurant.getMenu().loadMenu();
        restaurant.getStaffManager().loadStaff();

        do{
            System.out.println("Perform the following methods:");
            System.out.println("1: Display Menu");
            System.out.println("2: Edit Menu");
            System.out.println("3: Display Empty Tables");
            System.out.println("4: Assign New Customer");
            System.out.println("5: Create Order");
            System.out.println("6: View Order");
            System.out.println("7: Edit Order");
            System.out.println("8: Create Reservation Booking");
            System.out.println("9: Check Reservation Booking");
            System.out.println("10: Remove Reservation Booking");
            System.out.println("11: Make Payment / Print Order Invoice");
            System.out.println("12: Print Sales Revenue Report");
            System.out.println("13: Terminate the Programme");
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
                    restaurant.getReservationManager().updateReservationValidity(restaurant.getTableManager());
                    restaurant.getCustomerManager().assignNewCustomerToTable(restaurant.getTableManager());
                    break;
                case 5:
                    restaurant.getOrderManager().createOrder(restaurant.getTableManager(), restaurant.getStaffManager(), restaurant.getMenu());
                    break;
                case 6:
                    restaurant.getOrderManager().viewOrder(restaurant.getTableManager());
                    break;
                case 7:
                    restaurant.getOrderManager().editOrder(restaurant.getTableManager(), restaurant.getMenu());
                    break;
                case 8:
                    restaurant.getReservationManager().createReservation(restaurant.getTableManager(), restaurant.getCustomerManager());
                    break;
                case 9:
                    restaurant.getReservationManager().updateReservationValidity(restaurant.getTableManager());
                    restaurant.getReservationManager().checkReservation();
                    break;
                case 10:
                    restaurant.getReservationManager().removeReservation(restaurant.getTableManager());
                    break;
                case 11:
                    restaurant.getBillManager().generateBill(restaurant.getTableManager(), restaurant.getSalesRevenueReport());
                    break;
                case 12:
                    restaurant.getSalesRevenueReport().printSalesRevenueReport(restaurant.getBillManager().getBills());
                    break;
                case 13: 
                    System.out.println("Program terminating...");
                    break;
            }

        }while (choice < 13);

        try {
            FileOutputStream f = new FileOutputStream(new File("restaurant.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(restaurant);

			o.close();
			f.close();

            FileInputStream fi = new FileInputStream(new File("restaurant.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
            restaurant = (Restaurant) oi.readObject();

			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}  catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
}