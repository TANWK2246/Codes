import java.util.Scanner;
import java.util.ArrayList;

public class OrderUI {
    public static void orderCreator(Restaurant restaurant){
        Scanner sc = new Scanner(System.in);

        int staffID, tableID, itemID, quantity;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        System.out.println("Enter your staff ID:");
        staffID = sc.nextInt();
        while(StaffManager.validateStaffID(staffID, restaurant.getStaffArray()) == false){
            System.out.println("Invalid staff ID!");
            System.out.println("Enter your staff ID:");
            staffID = sc.nextInt();
        }

        System.out.println("Enter table ID:");
		tableID = sc.nextInt();
        while(TableManager.validateCustomerAtTable(tableID, restaurant.getTableArray()) == false){
            System.out.println("The table is empty");
            System.out.println("Enter table ID:");
            tableID = sc.nextInt();
        }

        restaurant.getMenu().displayMenu();
        System.out.println("Enter Item ID to be Ordered: (-1) to end");
        itemID = sc.nextInt();

        list1.clear();
        list2.clear();
        while(itemID != -1){
            list1.add(itemID);
            System.out.println("Enter quantity:");
            quantity = sc.nextInt();
            list2.add(quantity);
            System.out.println("Enter Item ID to be Ordered: (-1) to end");
            itemID = sc.nextInt();
        }

        OrderManager.createOrder(staffID, tableID, list1, list2, restaurant);
        System.out.println("Order created!");
    }

    public static void orderViewer(Restaurant restaurant){
        Scanner sc = new Scanner(System.in);
        int tableID;

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

        OrderManager.viewOrder(tableID, restaurant);
    }

    public static void orderEditor(Restaurant restaurant){
        Scanner sc = new Scanner(System.in);

        int tableID, itemID, quantity, choice;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

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

        do{
            System.out.println("(1) Add new Item:");
            System.out.println("(2) Edit quantity of an Item:");
            System.out.println("(3) Remove an Item:");
            System.out.println("(4) Done editing:");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    restaurant.getMenu().displayMenu();
                    System.out.println("Enter Item ID to be added into the order: (-1) to end");
                    itemID = sc.nextInt();
                    while(itemID != -1){
                        System.out.println("Enter quantity:");
                        quantity = sc.nextInt();
                        OrderManager.addItemIntoOrder(tableID, itemID, quantity, restaurant);
                        System.out.println("Enter Item ID to be Ordered: (-1) to end");
                        itemID = sc.nextInt();
                    }
                    break;
                case 2:
                    OrderManager.viewOrder(tableID, restaurant);
                    System.out.println("Enter ID of the item to change the quantity:");
                    itemID = sc.nextInt();
                    System.out.println("Enter the new quantity:");
                    quantity = sc.nextInt();
                    OrderManager.editQuantityOfItemOrder(tableID, itemID, quantity, restaurant);
                    break;
                case 3:
                    OrderManager.viewOrder(tableID, restaurant);
                    System.out.println("Enter ID to be removed from the order:");
                    itemID = sc.nextInt();
                    OrderManager.removeItemFromOrder(tableID, itemID, restaurant);
                    
                    break;
                case 4:
                    break;
            }
        }while(choice!=4);

        System.out.println("Order edited!");
    }
}
