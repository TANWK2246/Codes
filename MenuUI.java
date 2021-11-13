import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MenuUI{
    public static void menuEditor(Restaurant restaurant){
        int choice = 0;
        String name, description;
        double price;
        int itemType, itemID, setPackageID;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        do{
			try{
				System.out.println("====================");
            System.out.println("Menu Editing Panel:");
            System.out.println("1: Add Ala Carte Item");
            System.out.println("2: Edit Ala Carte Item");
			System.out.println("3: Remove Ala Carte Item");
            System.out.println("4: Add Set Package");
            System.out.println("5: Edit Set Package");
            System.out.println("6: Remove Set Package");
            System.out.println("7: Back to Home Page");
			choice = sc.nextInt();

            switch (choice) {
                case 1:
					System.out.println("Add Ala Carte Item");
					sc.nextLine();
					name = promptForMenuItemNameInput(restaurant.getMenu());
					description = promptForMenuItemDescriptionInput();
					price = promptForMenuItemPriceInput();
					itemType = promptForMenuItemTypeInput();
                    MenuManager.addAlaCarteItem(name, description, price, itemType, restaurant.getMenu());
                    break;
                case 2:
					System.out.println("Edit Ala Carte Item");
                    restaurant.getMenu().displayAlaCarteMenu();
					System.out.println("Enter ItemID to edit it: (-1) to go back to editing panel");
					itemID = promptForAlaCarteItemIDInput(restaurant.getMenu());
					if(itemID == -1){
						System.out.println("Going back to editing panel...");
						continue;
					}
					System.out.println("Enter (-1) to skip the part that you do not want to change.");
					sc.nextLine();
					name = promptForMenuItemNameInput(restaurant.getMenu());
					description = promptForMenuItemDescriptionInput();
					price = promptForMenuItemPriceInput();
					itemType = promptForMenuItemTypeInput();
					MenuManager.editAlaCarteItem(itemID, name, description, price, itemType, restaurant.getMenu());
                    break;
				case 3:
					System.out.println("Remove Ala Carte Item");
                    restaurant.getMenu().displayMenu();
					System.out.println("Enter ItemID to remove it: (-1) to go back to editing panel");
					itemID = promptForAlaCarteItemIDInput(restaurant.getMenu());
					if(itemID == -1){
						System.out.println("Going back to editing panel...");
						continue;
					}
                    MenuManager.removeAlaCarteItem(itemID, restaurant.getMenu());
                    break;
                case 4: 
					System.out.println("Add Set Package");
					sc.nextLine();
					name = promptForMenuItemNameInput(restaurant.getMenu());
					description = promptForMenuItemDescriptionInput();
					price = promptForMenuItemPriceInput();

					restaurant.getMenu().displayAlaCarteMenu();
                    
					System.out.println("Add item into the package, enter (-1) to end");

                    list1.clear();
					
                    itemID = promptForAlaCarteItemIDInput(restaurant.getMenu());
                    
					while (itemID != -1){
                        list1.add(itemID);	
						itemID = promptForAlaCarteItemIDInput(restaurant.getMenu());
					}

                    MenuManager.addSetPackage(name, description, price, list1, restaurant.getMenu());
                    break;
                case 5:
					System.out.println("Edit Set Package");
                    restaurant.getMenu().displaySetPackageMenu();

					System.out.println("Enter ItemID to edit it: (-1) to go back to editing panel");
					setPackageID = promptForSetPackageIDInput(restaurant.getMenu());
					if(setPackageID == -1){
						System.out.println("Going back to editing panel...");
						continue;
					}
					System.out.println("Enter (-1) to skip the part that you do not want to change.");
					sc.nextLine();
					name = promptForMenuItemNameInput(restaurant.getMenu());
					description = promptForMenuItemDescriptionInput();
					price = promptForMenuItemPriceInput();
					
                    restaurant.getMenu().displayAlaCarteMenu();

					System.out.println("Add item into the package, enter (-1) to end");

                    list1.clear();
					itemID = promptForAlaCarteItemIDInput(restaurant.getMenu());
					while (itemID != -1){
						list1.add(itemID);
						itemID = promptForAlaCarteItemIDInput(restaurant.getMenu());
					}

					System.out.println("Remove item from the package, enter(-1) to end");

                    list2.clear();
					itemID = promptForAlaCarteItemIDInput(restaurant.getMenu());
					while (itemID != -1){
						list2.add(itemID);
						itemID = promptForAlaCarteItemIDInput(restaurant.getMenu());
					}
					
                    MenuManager.editSetPackage(setPackageID, name, description, price, list1, list2, restaurant.getMenu());
					break;
				case 6:
					System.out.println("Remove Set Package");
					restaurant.getMenu().displaySetPackageMenu();

					System.out.println("Enter ItemID to remove it: (-1) to go back to editing panel");
					itemID = promptForSetPackageIDInput(restaurant.getMenu());
					if(itemID == -1){
						System.out.println("Going back to editing panel...");
						continue;
					}
                    MenuManager.removeSetPackage(itemID, restaurant.getMenu());
                    break;
                case 7: 
					System.out.println("Done editing, Back to Homepage...");
					break;
				default:
					System.out.println("Invalid option. Please enter again!");
					break;

            }
			}catch(InputMismatchException e){
				System.out.println("Invalid format. Please enter again!");
                sc.nextLine();
			}
			
        }while(choice != 7);
		
    }

	public static String promptForMenuItemNameInput(Menu menu){
		Scanner sc = new Scanner(System.in);
		String input;

		while(true){
			try{
				System.out.println("Enter Item/Package Name:");
				input = sc.nextLine();
				if(input.equals("-1")) return input;
				if(MenuManager.hasDuplicateItemName(input, menu)){
					System.out.println("The name has been taken. Please enter another name.");
					continue;
				}
				break;
			}catch (InputMismatchException e){
				System.out.println("Invalid name. Please enter again!");
			}
		}
		
		return input;
	}

	public static String promptForMenuItemDescriptionInput(){
		Scanner sc = new Scanner(System.in);
		String input;

		while(true){
			try{
				System.out.println("Enter Item/Package Description:");
				input = sc.nextLine();
				if(input.equals("-1")) return input;
				break;
			}catch (InputMismatchException e){
				System.out.println("Invalid description. Please enter again!");
				
			}
		}
		
		return input;
	}

	public static double promptForMenuItemPriceInput() {
		Scanner sc = new Scanner(System.in);
		double input;
		while(true){
			try{
				System.out.println("Enter Item Price:");
				input = sc.nextDouble();sc.nextLine();
				if(input == -1) return input;
				if(input < 0){
					System.out.println("Price must be a positive numebr.");
					continue;
				}
				break;
			}catch (InputMismatchException e){
				System.out.println("Invalid number. Please enter again!");
				sc.nextLine();
			}
		}
		
		return input;
	}

	public static int promptForMenuItemTypeInput() {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter Item Type: (1) MainCourse (2) Drinks (3) Dessert (4) SideDish");
				input = sc.nextInt();sc.nextLine();
				if(input < -1 | input == 0 | input > 4){
					System.out.println("Invalid Item Type.");
					continue;
				}
				break;
			}catch (InputMismatchException e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
		
		return input;
	}

	public static int promptForAlaCarteItemIDInput(Menu menu) {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter Item ID:");
				input = sc.nextInt();sc.nextLine();
				if(input == -1) return input;
				if(MenuManager.validateAlaCarteItemIDInput(input, menu) == false){
					System.out.println("Invalid Ala Carte Item ID.");
					continue;
				}
				break;
			}catch (InputMismatchException e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
		
		return input;
	}

	public static int promptForSetPackageIDInput(Menu menu) {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter Item ID:");
				input = sc.nextInt();sc.nextLine();
				if(input == -1) return input;
				if(MenuManager.validateSetPackageIDInput(input, menu) == false){
					System.out.println("Invalid Set Package ID.");
					continue;
				}
				break;
			}catch (InputMismatchException e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
		
		return input;
	}

}