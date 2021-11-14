import java.util.ArrayList;

/**
 * The type Order manager.
 */
public class OrderManager{
    /**
     * Create order.
     *
     * @param staffID    the staff id
     * @param tableID    the table id
     * @param list1      the list of menu item id to be added into the order
     * @param list2      the list of corresponding quantity of each menu item to be added into the order
     * @param staffArray the staff array
     * @param tableArray the table array
     * @param menu       the menu
     */
    public static void createOrder(int staffID, int tableID, ArrayList<Integer> list1, ArrayList<Integer> list2, StaffArray staffArray, TableArray tableArray, Menu menu){
        Customer customer;
        Staff staff;
        Order newOrder;

        staff = StaffManager.getStaffByID(staffID, staffArray);
        customer = tableArray.getTables().get(tableID).getCustomer();
        
        newOrder = new Order(staff, customer);
        customer.setOrder(newOrder);

        for(int i = 0; i < list1.size(); i++){
            newOrder.getItemOrder().add(new ItemOrder(menu.getMenuItems().get(list1.get(i)),list2.get(i)));
        }
    }

    /**
     * View order int.
     *
     * @param tableID    the table id
     * @param tableArray the table array
     * @return the number of item order
     */
    public static int viewOrder(int tableID, TableArray tableArray){
        Order order = tableArray.getTables().get(tableID).getCustomer().getOrder();
        return order.printOrder();
    }

    /**
     * Add item into order.
     *
     * @param tableID    the table id
     * @param itemID     the item id of the menu item to be added into the order
     * @param quantity   the quantity of the menu item to be added into the order
     * @param tableArray the table array
     * @param menu       the menu
     */
    public static void addItemIntoOrder(int tableID, int itemID, int quantity, TableArray tableArray, Menu menu){
        Order order = tableArray.getTables().get(tableID).getCustomer().getOrder();
        MenuItem newItem = menu.getMenuItems().get(itemID);
        order.getItemOrder().add((new ItemOrder(newItem, quantity)));
    }

    /**
     * Remove item from order.
     *
     * @param tableID    the table id
     * @param itemID     the item id of the item order to be removed into the order
     * @param tableArray the table array
     */
    public static void removeItemFromOrder(int tableID, int itemID, TableArray tableArray){
        Order order = tableArray.getTables().get(tableID).getCustomer().getOrder();
        order.getItemOrder().remove(itemID);
    }

    /**
     * Edit quantity of item order.
     *
     * @param tableID    the table id
     * @param itemID     the item id of the item order to be edited 
     * @param quantity   the new quantity
     * @param tableArray the table array
     */
    public static void editQuantityOfItemOrder(int tableID, int itemID, int quantity, TableArray tableArray){
        Order order = tableArray.getTables().get(tableID).getCustomer().getOrder();
        order.getItemOrder().get(itemID).setQuantity(quantity);
    }


}
