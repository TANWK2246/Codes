import java.util.Scanner;

public class OrderManager {
    public void createOrder(TableManager tablaManager, StaffManager staffManager, Menu menu){
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
        if(tablaManager.getTable(tableID).getIsOccupied() == true){
            customer = tablaManager.getTable(tableID).getCustomer();
        }else{
            System.out.println("There is no customer on the table.");
            return;
        }
        
        newOrder = new Order(staff, customer);

        menu.displayAlaCarteMenu();
        System.out.println("Enter Ala Carte Item ID to be Ordered: (-1) to end");
        itemID = sc.nextInt();
        while(itemID != -1){
            newItem = menu.getAlaCarteItem(itemID);
            System.out.println("Enter quantity:");
            quantity = sc.nextInt();
            newOrder.addItemOrder(new ItemOrder(newItem, quantity));
        }

        menu.displaySetPackageMenu();
        System.out.println("Enter Set Package ID to be Ordered: (-1) to end");
        itemID = sc.nextInt();
        while(itemID != -1){
            newItem = menu.getSetPackage(itemID);
            System.out.println("Enter quantity:");
            quantity = sc.nextInt();
            newOrder.addItemOrder(new ItemOrder(newItem, quantity));
        }
    }
}
