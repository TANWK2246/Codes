import java.util.Scanner;

public class OrderManager {
    public void createOrder(TableManager tableManager, StaffManager staffManager, Menu menu){
        Scanner sc = new Scanner(System.in);

        int tableID, staffID, itemID, quantity;
        Customer customer;
        Staff staff;
        Order newOrder;
        MenuItem newItem;

        System.out.println("Enter your staff ID:");
        staffID = sc.nextInt();
        staff = staffManager.getStaff(staffID);
        
        System.out.println("Enter table ID:");
		tableID = sc.nextInt();
        if(tableManager.getTable(tableID).getIsOccupied() == true){
            customer = tableManager.getTable(tableID).getCustomer();
        }else{
            System.out.println("There is no customer on the table.");
            return;
        }
        
        newOrder = new Order(staff, customer);
        customer.setOrder(newOrder);

        menu.displayMenu();
        System.out.println("Enter Item ID to be Ordered: (-1) to end");
        itemID = sc.nextInt();
        while(itemID != -1){
            newItem = menu.getItem(itemID);
            System.out.println("Enter quantity:");
            quantity = sc.nextInt();
            newOrder.addItemOrder(new ItemOrder(newItem, quantity));
            System.out.println("Enter Item ID to be Ordered: (-1) to end");
            itemID = sc.nextInt();
        }
    }

    public void viewOrder(TableManager tableManager){
        Scanner sc = new Scanner(System.in);
        int tableID;
        System.out.println("Enter table ID:");
		tableID = sc.nextInt();

        Order order = tableManager.getTable(tableID).getCustomer().getOrder();

        if(order == null){
            System.out.println("There is no order for this table yet.");
            return;
        }

        order.printOrder();
    }

    public void editOrder(TableManager tableManager, Menu menu){
        Scanner sc = new Scanner(System.in);
        int tableID;
        System.out.println("Enter table ID:");
		tableID = sc.nextInt();

        Order order = tableManager.getTable(tableID).getCustomer().getOrder();

        if(order == null){
            System.out.println("There is no order for this table yet.");
            return;
        }

        int choice, itemID, quantity;
        MenuItem newItem;
        do{
            System.out.println("(1) Add new Item:");
            System.out.println("(2) Edit quantity of an Item:");
            System.out.println("(3) Remove an Item:");
            System.out.println("(4) Done editing:");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    menu.displayMenu();
                    System.out.println("Enter Item ID to be added into the order: (-1) to end");
                    itemID = sc.nextInt();
                    while(itemID != -1){
                        newItem = menu.getItem(itemID);
                        System.out.println("Enter quantity:");
                        quantity = sc.nextInt();
                        order.addItemOrder((new ItemOrder(newItem, quantity)));
                        System.out.println("Enter Item ID to be Ordered: (-1) to end");
                        itemID = sc.nextInt();
                    }
                    break;
                case 2:
                    order.printOrder();
                    System.out.println("Enter ID of the item to change the quantity:");
                    itemID = sc.nextInt();
                    System.out.println("Enter the new quantity:");
                    quantity = sc.nextInt();
                    order.editQuantityofItemOrder(itemID, quantity);
                    break;
                case 3:
                    order.printOrder();
                    System.out.println("Enter ID to be removed from the order:");
                    itemID = sc.nextInt();
                    order.removeItemOrder(itemID);
                    break;
                case 4:
                    break;
            }
        }while(choice!=4);
    }
}
