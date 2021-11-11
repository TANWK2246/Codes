import java.util.Scanner;
import java.util.ArrayList;

public class OrderManager{
    public static void createOrder(int staffID, int tableID, ArrayList<Integer> list1, ArrayList<Integer> list2, Restaurant restaurant){
        Customer customer;
        Staff staff;
        Order newOrder;

        staff = StaffManager.getStaff(staffID, restaurant.getStaffArray());
        customer = TableManager.getTable(tableID, restaurant.getTableArray()).getCustomer();
        
        newOrder = new Order(staff, customer);
        customer.setOrder(newOrder);

        for(int i = 0; i < list1.size(); i++){
            newOrder.addItemOrder(new ItemOrder(restaurant.getMenu().getItem(list1.get(i)),list2.get(i)));
        }
    }

    public static void viewOrder(int tableID, Restaurant restaurant){
        Scanner sc = new Scanner(System.in);

        Order order = TableManager.getTable(tableID, restaurant.getTableArray()).getCustomer().getOrder();

        if(order == null){
            System.out.println("There is no order for this table yet.");return;
        }

        order.printOrder();

    }

    public static void addItemIntoOrder(int tableID, int itemID, int quantity, Restaurant restaurant){
        Order order = TableManager.getTable(tableID, restaurant.getTableArray()).getCustomer().getOrder();
        MenuItem newItem = restaurant.getMenu().getItem(itemID);
        order.addItemOrder((new ItemOrder(newItem, quantity)));
    }

    public static void removeItemFromOrder(int tableID, int itemID, Restaurant restaurant){
        Order order = TableManager.getTable(tableID, restaurant.getTableArray()).getCustomer().getOrder();
        order.removeItemOrder(itemID);
    }

    public static void editQuantityOfItemOrder(int tableID, int itemID, int quantity, Restaurant restaurant){
        Order order = TableManager.getTable(tableID, restaurant.getTableArray()).getCustomer().getOrder();
        order.editQuantityofItemOrder(itemID, quantity);
    }


}
