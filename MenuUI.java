import java.util.Scanner;
import java.util.ArrayList;

public class MenuUI{
    public static void menuEditor(Restaurant restaurant){
        int choice;
        String name, description;
        double price;
        int itemType, itemID;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Menu editing:");
            System.out.println("1: Add Ala Carte Item");
            System.out.println("2: Edit Ala Carte Item");
			System.out.println("3: Remove ALa Carte Item");
            System.out.println("4: Add Set Package");
            System.out.println("5: Edit Set Package");
            System.out.println("6: Remove Set Package");
            System.out.println("7: Done");
			choice = sc.nextInt();

            switch (choice) {
                case 1:
					System.out.println("Enter Item Name:");
					sc.nextLine();
					name = sc.nextLine();
					System.out.println("Enter Item Description:");
					description = sc.nextLine();
					System.out.println("Enter Item Price:");
					price = sc.nextDouble();
					System.out.println("Enter Item Type: (1) MainCourse (2) Drinks (3) Dessert (4) SideDish");
					itemType = sc.nextInt();
                    MenuManager.addAlaCarteItem(name, description, price, itemType, restaurant.getMenu());
                    break;
                case 2: 
                    restaurant.getMenu().displayAlaCarteMenu();

					System.out.println("Enter the itemID to be edited:");
                    itemID = sc.nextInt();
					System.out.println("Enter Item Name: (or -1 to skip)");
					sc.nextLine();
					name = sc.nextLine();
					System.out.println("Enter Item Description: (or -1 to skip)");
					description = sc.nextLine();
					System.out.println("Enter Item Price: (or -1 to skip)");
					price = sc.nextDouble();
					System.out.println("Enter Item Type: (1) MainCourse (2) Drinks (3) Dessert (4) SideDish (-1) Skip");
					itemType = sc.nextInt();
                    MenuManager.editAlaCarteItem(itemID, name, description, price, itemType, restaurant.getMenu());
                    break;
				case 3:
                    restaurant.getMenu().displayMenu();
					System.out.println("Enter the itemID to be removed:");
					itemID = sc.nextInt();
                    MenuManager.removeAlaCarteItem(itemID, restaurant.getMenu());
                    break;
                case 4: 
					System.out.println("Enter Set Package Name:");
					sc.nextLine(); name = sc.nextLine();
					System.out.println("Enter Set Package Description:");
					description = sc.nextLine();
					System.out.println("Enter Set Package Price:");
					price = sc.nextDouble();

					restaurant.getMenu().displayAlaCarteMenu();
                    
					System.out.println("Add item into the package, enter (-1) to end");

                    list1.clear();
					
                    System.out.println("\tEnter itemID:");
                    itemID = sc.nextInt();
                    
					while (itemID != -1){
                        list1.add(itemID);	
						System.out.println("\tEnter itemID:");
						itemID = sc.nextInt();
					}

                    MenuManager.addSetPackage(name, description, price, list1, restaurant.getMenu());
                    break;

                case 5:
                    restaurant.getMenu().displaySetPackageMenu();

					System.out.println("Enter the itemID to be edited:");
					itemID = sc.nextInt();
					System.out.println("Enter Set Package Name: (or -1 to skip)");
					sc.nextLine();
					name = sc.nextLine();
					System.out.println("Enter Set Package Description: (or -1 to skip)");
					description = sc.nextLine();
					System.out.println("Enter Set Package Price: (or -1 to skip)");
					price = sc.nextDouble();
					
                    restaurant.getMenu().displayAlaCarteMenu();

					System.out.println("Enter itemID to add item into the package, enter (-1) to end");

                    list1.clear();
					System.out.println("\tEnter itemID:");
					itemID = sc.nextInt();
					while (itemID != -1){
						list1.add(itemID);
						System.out.println("\tEnter itemID:");
						itemID = sc.nextInt();
					}

					System.out.println("Enter itemID to remove item from the package, enter(-1) to end");

                    list2.clear();
					System.out.println("\tEnter itemID:");
					itemID = sc.nextInt();
					while (itemID != -1){
						list2.add(itemID);
						System.out.println("\tEnter itemID:");
						itemID = sc.nextInt();
					}
					
                    MenuManager.editSetPackage(itemID, name, description, price, list1, list2, restaurant.getMenu());
					break;
                
				case 6:
                    restaurant.getMenu().displayMenu();
					System.out.println("Enter the itemID to be removed:");
					itemID = sc.nextInt();
                    MenuManager.removeSetPackage(itemID, restaurant.getMenu());
                    break;
                
                case 7: System.out.println("Done editing, Back to Homepage...");

            }
        }while(choice < 6);
    }
}