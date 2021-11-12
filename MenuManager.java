import java.util.ArrayList;

public class MenuManager{
    public MenuManager(){}
    public static void addAlaCarteItem(String name, String description, double price, int itemType, Menu menu){
        AlaCarteItem newItem = new AlaCarteItem(name, description, price, itemType);
        menu.addItem(newItem);
        newItem.displayMenuItem();
	}

    public static void editAlaCarteItem(int itemID, String name, String description, double price, int itemType, Menu menu){
        AlaCarteItem itemToBeEdited = (AlaCarteItem) menu.getItem(itemID);

        if(!name.equals("-1")) itemToBeEdited.setName(name);
        if(!description.equals("-1")) itemToBeEdited.setDescription(description);
        if(price != -1) itemToBeEdited.setPrice(price);
        if(itemType != -1) itemToBeEdited.setItemType(itemType);
        
        System.out.println("AlaCarteItem " + itemToBeEdited.getName() + " has been edited.");
        itemToBeEdited.displayMenuItem();
    }

    public static void editSetPackage(int itemID, String name, String description, double price, ArrayList<Integer> list1, ArrayList<Integer> list2, Menu menu){
        SetPackage setPackageToBeEdited = (SetPackage) menu.getItem(itemID);

        if(!name.equals("-1")) setPackageToBeEdited.setName(name);
        if(!description.equals("-1")) setPackageToBeEdited.setDescription(description);
        if(price != -1) setPackageToBeEdited.setPrice(price);

        for(int i : list1){
            setPackageToBeEdited.addItem((AlaCarteItem) menu.getItem(i));
        }

        for(int i : list2){
            setPackageToBeEdited.removeItem((AlaCarteItem) menu.getItem(i));
        }

        System.out.println("SetPackage " + setPackageToBeEdited.getName() + " has been edited.");
        setPackageToBeEdited.displayMenuItem();
    }

    public static void removeAlaCarteItem(int itemID, Menu menu){
        AlaCarteItem itemToBeRemoved = (AlaCarteItem) menu.getItem(itemID);
        menu.removeItem(itemToBeRemoved); 

        System.out.println("Menu Item " + itemToBeRemoved.getName() + " has been removed.");
    }

    public static void addSetPackage(String name, String description, double price, ArrayList<Integer> list, Menu menu){
        SetPackage newPackage = new SetPackage(name, description, price);
        for(int itemID : list){
            newPackage.addItem((AlaCarteItem) menu.getItem(itemID));
        }
        menu.addItem(newPackage);
        newPackage.displayMenuItem();
    }

    public static void removeSetPackage(int itemID, Menu menu){
        SetPackage itemToBeRemoved = (SetPackage) menu.getItem(itemID);
        menu.removeItem(itemToBeRemoved); 

        System.out.println("Menu Item " + itemToBeRemoved.getName() + " has been removed.");
    }

    public static boolean hasDuplicateItemName(String name, Menu menu){
        for(MenuItem menuItem : menu.getMenuItems()){
            if(name.equals(menuItem.getName())) return true;
        }
        return false;
    }

    public static boolean validateAlaCarteItemIDInput(int itemID, Menu menu){
        if(itemID >= 0 & itemID < menu.getNoOfAlaCarteItems()) return true;
        return false;
    }

    public static boolean validateSetPackageIDInput(int itemID, Menu menu){
        if(itemID >= menu.getNoOfAlaCarteItems() & itemID < menu.getMenuItems().size()) return true;
        return false;
    }

    public static boolean validateMenuItemIDInput(int itemID, Menu menu){
        if(itemID >= 0 & itemID < menu.getMenuItems().size()) return true;
        return false;
    }

}
