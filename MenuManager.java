import java.util.ArrayList;

/**
 * The type Menu manager.
 */
public class MenuManager{
    /**
     * Add ala carte item into the menu.
     *
     * @param name        the name
     * @param description the description
     * @param price       the price
     * @param itemType    the item type
     * @param menu        the menu
     */
    public static void addAlaCarteItem(String name, String description, double price, int itemType, Menu menu){
        AlaCarteItem newItem = new AlaCarteItem(name, description, price, itemType);
        menu.getMenuItems().add(menu.getNoOfAlaCarteItems(), newItem);
        menu.setNoOfAlaCarteItems(menu.getNoOfAlaCarteItems() + 1);
        newItem.displayMenuItem();
	}
    
    /**
     * Edit ala carte item in the menu.
     *
     * @param itemID      the item id
     * @param name        the name or "-1" if the name if not to be edited
     * @param description the description or "-1" if the description if not to be edited
     * @param price       the price or -1 if the price if not to be edited
     * @param itemType    the item type or -1 if the item type if not to be edited
     * @param menu        the menu
     */
    public static void editAlaCarteItem(int itemID, String name, String description, double price, int itemType, Menu menu){
        AlaCarteItem itemToBeEdited = (AlaCarteItem) menu.getMenuItems().get(itemID);

        if(!name.equals("-1")) itemToBeEdited.setName(name);
        if(!description.equals("-1")) itemToBeEdited.setDescription(description);
        if(price != -1) itemToBeEdited.setPrice(price);
        if(itemType != -1) itemToBeEdited.setItemType(itemType);
        
        System.out.println("AlaCarteItem " + itemToBeEdited.getName() + " has been edited.");
        itemToBeEdited.displayMenuItem();
    }

    /**
     * Remove ala carte item from the menu.
     *
     * @param itemID the item id
     * @param menu   the menu
     */
    public static void removeAlaCarteItem(int itemID, Menu menu){
        AlaCarteItem itemToBeRemoved = (AlaCarteItem) menu.getMenuItems().get(itemID);
        menu.getMenuItems().remove(itemToBeRemoved);
        menu.setNoOfAlaCarteItems(menu.getNoOfAlaCarteItems() - 1);
        System.out.println("Menu Item " + itemToBeRemoved.getName() + " has been removed.");
    }

    /**
     * Add set package into the menu.
     *
     * @param name        the name
     * @param description the description
     * @param price       the price
     * @param list        the list of ala carte items to be included in the set package
     * @param menu        the menu
     */
    public static void addSetPackage(String name, String description, double price, ArrayList<Integer> list, Menu menu){
        SetPackage newPackage = new SetPackage(name, description, price);
        for(int itemID : list){
            newPackage.addItem((AlaCarteItem) menu.getMenuItems().get(itemID));
        }
        menu.getMenuItems().add(newPackage);
        newPackage.displayMenuItem();
    }

    
    /**
     * Edit set package in the menu.
     *
     * @param itemID      the item id
     * @param name         the name or "-1" if the name if not to be edited
     * @param description the description or "-1" if the description if not to be edited
     * @param price       the price or -1 if the price if not to be edited
     * @param list1       the list of ala carte items to be added into the set package
     * @param list2       the list of ala carte items to be removed from the set package
     * @param menu        the menu
     */
    public static void editSetPackage(int itemID, String name, String description, double price, ArrayList<Integer> list1, ArrayList<Integer> list2, Menu menu){
        SetPackage setPackageToBeEdited = (SetPackage) menu.getMenuItems().get(itemID);

        if(!name.equals("-1")) setPackageToBeEdited.setName(name);
        if(!description.equals("-1")) setPackageToBeEdited.setDescription(description);
        if(price != -1) setPackageToBeEdited.setPrice(price);

        for(int i : list1){
            setPackageToBeEdited.addItem((AlaCarteItem) menu.getMenuItems().get(i));
        }

        for(int i : list2){
            setPackageToBeEdited.removeItem((AlaCarteItem) menu.getMenuItems().get(i));
        }

        System.out.println("SetPackage " + setPackageToBeEdited.getName() + " has been edited.");
        setPackageToBeEdited.displayMenuItem();
    }

    /**
     * Remove set package from the menu.
     *
     * @param itemID the item id
     * @param menu   the menu
     */
    public static void removeSetPackage(int itemID, Menu menu){
        SetPackage itemToBeRemoved = (SetPackage) menu.getMenuItems().get(itemID);
        menu.getMenuItems().remove(itemToBeRemoved); 

        System.out.println("Menu Item " + itemToBeRemoved.getName() + " has been removed.");
    }

    
    /**
     * Validate if a menu item name has been used before.
     *
     * @param name the name
     * @param menu the menu
     * @return true if the name has appeared in the menu, false otherwise
     */
    public static boolean hasDuplicateItemName(String name, Menu menu){
        for(MenuItem menuItem : menu.getMenuItems()){
            if(name.equals(menuItem.getName())) return true;
        }
        return false;
    }

    
    /**
     * Validate ala carte item id input.
     *
     * @param itemID the item id
     * @param menu   the menu
     * @return true if the item id refers to an ala carte item, false otherwise
     */
    public static boolean validateAlaCarteItemIDInput(int itemID, Menu menu){
        if(itemID >= 0 & itemID < menu.getNoOfAlaCarteItems()) return true;
        return false;
    }

    /**
     * Validate set package id input.
     *
     * @param itemID the item id
     * @param menu   the menu
     * @return true if the item id refers to a set package, false otherwise
     */
    public static boolean validateSetPackageIDInput(int itemID, Menu menu){
        if(itemID >= menu.getNoOfAlaCarteItems() & itemID < menu.getMenuItems().size()) return true;
        return false;
    }

    /**
     * Validate menu item id input.
     *
     * @param itemID the item id
     * @param menu   the menu
     * @return true if the item id refers to a menu item, false otherwise
     */
    public static boolean validateMenuItemIDInput(int itemID, Menu menu){
        if(itemID >= 0 & itemID < menu.getMenuItems().size()) return true;
        return false;
    }

}
