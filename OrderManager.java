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

        menu.displayAlaCarteMenu();
        System.out.println("Enter Ala Carte Item ID to be Ordered: (-1) to end");
        itemID = sc.nextInt();
        while(itemID != -1){
            newItem = menu.getAlaCarteItem(itemID);
            System.out.println("Enter quantity:");
            quantity = sc.nextInt();
            newOrder.addItemOrder(new ItemOrder(newItem, quantity));
            System.out.println("Enter Ala Carte Item ID to be Ordered: (-1) to end");
            itemID = sc.nextInt();
        }

        menu.displaySetPackageMenu();
        System.out.println("Enter Set Package ID to be Ordered: (-1) to end");
        itemID = sc.nextInt();
        while(itemID != -1){
            newItem = menu.getSetPackage(itemID);
            System.out.println("Enter quantity:");
            quantity = sc.nextInt();
            newOrder.addItemOrder(new ItemOrder(newItem, quantity));
            System.out.println("Enter Set Package ID to be Ordered: (-1) to end");
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
}
