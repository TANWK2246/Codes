import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * The type Order ui.
 */
public class OrderUI {
    /**
     * Order creator ui.
     *
     * @param restaurant the restaurant
     */
    public static void orderCreator(Restaurant restaurant){
        int staffID, tableID, itemID, quantity;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        staffID = promptForStaffIDInput(restaurant.getStaffArray());

        tableID = promptForWithCustomerTableIDInput(restaurant.getTableArray());
        if(tableID == -1){
            System.out.println("Going back to home page...");
			return;
        }

        restaurant.getMenu().displayMenu();
        System.out.println("Add Item into Order, (-1) to end");
        itemID = promptForMenuItemIDInput(restaurant.getMenu());

        list1.clear();
        list2.clear();
        while(itemID != -1){
            list1.add(itemID);
            quantity = promptForQuantityInput();
            list2.add(quantity);
            itemID = promptForMenuItemIDInput(restaurant.getMenu());
        }

        OrderManager.createOrder(staffID, tableID, list1, list2, restaurant.getStaffArray(), restaurant.getTableArray(), restaurant.getMenu());
        System.out.println("Order created!");
    }

    /**
     * Order viewer ui.
     *
     * @param restaurant the restaurant
     */
    public static void orderViewer(Restaurant restaurant){
        Scanner sc = new Scanner(System.in);
        int tableID;

        tableID = promptForWithOrderTableIDInput(restaurant.getTableArray());
        if(tableID == -1){
            System.out.println("Going back to home page...");
            
			return;
        }

        OrderManager.viewOrder(tableID, restaurant.getTableArray());
        
    }

    /**
     * Order editor ui.
     *
     * @param restaurant the restaurant
     */
    public static void orderEditor(Restaurant restaurant){
        Scanner sc = new Scanner(System.in);

        int tableID, itemID, quantity, choice = 0, noOfItemOrder;

        tableID = promptForWithOrderTableIDInput(restaurant.getTableArray());
        if(tableID == -1){
            System.out.println("Going back to home page...");
            
			return;
        }

        do{
            try{
                System.out.println("====================");
                System.out.println("Order Editing Panel:");
                System.out.println("1: Add new Item");
                System.out.println("2: Edit quantity of an Item");
                System.out.println("3: Remove an Item");
                System.out.println("4: Done editing");
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        restaurant.getMenu().displayMenu();
                        System.out.println("Add Item into Order, (-1) to end");
                        itemID = promptForMenuItemIDInput(restaurant.getMenu());
                        
                        while(itemID != -1){
                            quantity = promptForQuantityInput();
                            OrderManager.addItemIntoOrder(tableID, itemID, quantity, restaurant.getTableArray(), restaurant.getMenu());
                            itemID = promptForMenuItemIDInput(restaurant.getMenu());
                        }
                        break;
                    case 2:
                        noOfItemOrder = OrderManager.viewOrder(tableID, restaurant.getTableArray());
                        System.out.println("Edit item in the order");
                        itemID = promptForItemOrderIDInput(noOfItemOrder);
                        quantity = promptForQuantityInput();
                        OrderManager.editQuantityOfItemOrder(tableID, itemID, quantity, restaurant.getTableArray());
                        break;
                    case 3:
                        noOfItemOrder = OrderManager.viewOrder(tableID, restaurant.getTableArray());
                        System.out.println("Remove item from the order");
                        itemID = promptForItemOrderIDInput(noOfItemOrder);
                        OrderManager.removeItemFromOrder(tableID, itemID, restaurant.getTableArray());
                        break;
                    case 4:
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
        }while(choice!=4);
    }

    /**
     * Prompt for staff id input int.
     *
     * @param staffArray the staff array
     * @return the staff id input int
     */
    public static int promptForStaffIDInput(StaffArray staffArray) {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter your Staff ID:");
				input = sc.nextInt();sc.nextLine();
                if(StaffManager.validateStaffID(input, staffArray) == true)
                break;
                System.out.println("Invalid Staff ID:");
			}catch (Exception e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
        
		return input;
	}

    /**
     * Prompt for with customer table id input int.
     *
     * @param tableArray the table array
     * @return the table id input int
     */
    public static int promptForWithCustomerTableIDInput(TableArray tableArray) {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter table ID:");
				input = sc.nextInt();sc.nextLine();
                if(input == -1)break;
                
                if(TableManager.validateCustomerAtTable(input, tableArray) == true) break;
                System.out.println("The table is not occupied by customer. Try again or enter (-1) to go back.");
			}catch (InputMismatchException e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}catch (IndexOutOfBoundsException e){
                System.out.println("Invalid Table ID. Please enter again!");
				sc.nextLine();
            }
		}
		return input;
	}

    /**
     * Prompt for with order table id input int.
     *
     * @param tableArray the table array
     * @return the table id input int
     */
    public static int promptForWithOrderTableIDInput(TableArray tableArray) {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter table ID:");
				input = sc.nextInt();sc.nextLine();
                if(input == -1) break;
                if(TableManager.validateCustomerAtTable(input, tableArray) == false){
                    System.out.println("The table is not occupied by customer. Try again or enter (-1) to go back.");
                    continue;
                }
                if(TableManager.validateOrderExists(input, tableArray) == false){
                    System.out.println("The table has no order yet. Please create an order first. Try again or enter (-1) to go back.");
                    continue;
                }
                return input;
			}catch (InputMismatchException e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}catch (IndexOutOfBoundsException e){
                System.out.println("Invalid Table ID. Please enter again!");
				sc.nextLine();
            }
		}
        
		return input;
	}

    /**
     * Prompt for menu item id input int.
     *
     * @param menu the menu
     * @return the menu item id input int
     */
    public static int promptForMenuItemIDInput(Menu menu) {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter Item ID:");
				input = sc.nextInt();sc.nextLine();
                if(input == -1) return input;
				if(MenuManager.validateMenuItemIDInput(input, menu) == false){
					System.out.println("Invalid Menu Item ID.");
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

    /**
     * Prompt for item order id input int.
     *
     * @param noOfItemOrder the number of item order
     * @return the item order id input int
     */
    public static int promptForItemOrderIDInput(int noOfItemOrder) {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter Item ID:");
				input = sc.nextInt();sc.nextLine();
                if(input >= 0 & input < noOfItemOrder) break;
                System.out.println("Invalid item order ID.");
			}catch (InputMismatchException e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
        
		return input;
	}

    /**
     * Prompt for quantity input. Quantity must be greater than zero.
     *
     * @return the quantity input int
     */
    public static int promptForQuantityInput() {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter quantity:");
				input = sc.nextInt();sc.nextLine();
                if(input > 0) break;
                System.out.println("Please enter a positive integer.");
			}catch (InputMismatchException e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
        
		return input;
	}

}
