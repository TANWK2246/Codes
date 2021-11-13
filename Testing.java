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

        restaurant.getTableArray().loadTable();
        restaurant.getMenu().loadMenu();
        restaurant.getStaffArray().loadStaff();

        
        try {
            FileOutputStream f = new FileOutputStream(new File("restaurant.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(restaurant);

			o.close();
			f.close();

            FileInputStream fi = new FileInputStream(new File("restaurant.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

            restaurant = null;
            System.out.println("remove restaurant");

			// Read objects
            restaurant = (Restaurant) oi.readObject();
            System.out.println("Read restaurant");

			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}  catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

        restaurant.getMenu().displayMenu();
        restaurant.getTableArray().showEmptyTables();
    }
    
}