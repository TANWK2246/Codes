import java.util.Scanner;
import java.util.ArrayList;

public class OrderUI {
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

    public static void orderViewer(Restaurant restaurant){
        Scanner sc = new Scanner(System.in);
        int tableID;

        tableID = promptForWithCustomerTableIDInput(restaurant.getTableArray());
        if(tableID == -1){
            System.out.println("Going back to home page...");
            sc.close();
			return;
        }

        OrderManager.viewOrder(tableID, restaurant.getTableArray());
        sc.close();
    }

    public static void orderEditor(Restaurant restaurant){
        Scanner sc = new Scanner(System.in);

        int tableID, itemID, quantity, choice, noOfItemOrder;

        tableID = promptForWithCustomerTableIDInput(restaurant.getTableArray());
        if(tableID == -1){
            System.out.println("Going back to home page...");
            sc.close();
			return;
        }

        do{
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
                    break;
            }
        }while(choice!=4);

        System.out.println("Order edited!");
        sc.close();
    }

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
        sc.close();
		return input;
	}

    public static int promptForWithCustomerTableIDInput(TableArray tableArray) {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter table ID:");
				input = sc.nextInt();sc.nextLine();
                if(TableManager.validateCustomerAtTable(input, tableArray) == true | input == -1) 
                break;
                System.out.println("The table is not occupied by customer.");
			}catch (Exception e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
        sc.close();
		return input;
	}

    public static int promptForWithOrderTableIDInput(TableArray tableArray) {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter table ID:");
				input = sc.nextInt();sc.nextLine();
                if(input == -1) break;
                if(TableManager.validateCustomerAtTable(input, tableArray) == true){
                    System.out.println("The table is not occupied by customer.");
                    continue;
                }
                if(TableManager.validateOrderExists(input, tableArray) == false){
                    System.out.println("The table has no order yet. Please create an order first.");
                    return -1;
                }
			}catch (Exception e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
        sc.close();
		return input;
	}

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
			}catch (Exception e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
        sc.close();
		return input;
	}

    public static int promptForItemOrderIDInput(int noOfItemOrder) {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter Item ID:");
				input = sc.nextInt();sc.nextLine();
                if(input >= 0 & input < noOfItemOrder) break;
                System.out.println("Invalid item order ID.");
			}catch (Exception e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
        sc.close();
		return input;
	}

    public static int promptForQuantityInput() {
		Scanner sc = new Scanner(System.in);
		int input;
		while(true){
			try{
				System.out.println("Enter quantity:");
				input = sc.nextInt();sc.nextLine();
                if(input > 0) break;
                System.out.println("Please enter a positive integer.");
			}catch (Exception e){
				System.out.println("Invalid integer. Please enter again!");
				sc.nextLine();
			}
		}
        sc.close();
		return input;
	}

}
