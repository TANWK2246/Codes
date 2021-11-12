import java.util.ArrayList;

public class OrderManager{
    public static void createOrder(int staffID, int tableID, ArrayList<Integer> list1, ArrayList<Integer> list2, StaffArray staffArray, TableArray tableArray, Menu menu){
        Customer customer;
        Staff staff;
        Order newOrder;

        staff = StaffManager.getStaff(staffID, staffArray);
        customer = TableManager.getTable(tableID, tableArray).getCustomer();
        
        newOrder = new Order(staff, customer);
        customer.setOrder(newOrder);

        for(int i = 0; i < list1.size(); i++){
            newOrder.addItemOrder(new ItemOrder(menu.getItem(list1.get(i)),list2.get(i)));
        }
    }

    public static int viewOrder(int tableID, TableArray tableArray){
        Order order = TableManager.getTable(tableID, tableArray).getCustomer().getOrder();
        return order.printOrder();

    }

    public static void addItemIntoOrder(int tableID, int itemID, int quantity, TableArray tableArray, Menu menu){
        Order order = TableManager.getTable(tableID, tableArray).getCustomer().getOrder();
        MenuItem newItem = menu.getItem(itemID);
        order.addItemOrder((new ItemOrder(newItem, quantity)));
    }

    public static void removeItemFromOrder(int tableID, int itemID, TableArray tableArray){
        Order order = TableManager.getTable(tableID, tableArray).getCustomer().getOrder();
        order.removeItemOrder(itemID);
    }

    public static void editQuantityOfItemOrder(int tableID, int itemID, int quantity, TableArray tableArray){
        Order order = TableManager.getTable(tableID, tableArray).getCustomer().getOrder();
        order.editQuantityofItemOrder(itemID, quantity);
    }


}
