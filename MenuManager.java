import java.util.ArrayList;

public class MenuManager{
    public MenuManager(){}
    public static void addAlaCarteItem(String name, String description, double price, int itemType, Menu menu){
        MenuItem newItem = new AlaCarteItem(name, description, price, itemType);
        menu.addItem(newItem);
        newItem.displayMenuItem();
	}

    public static void editAlaCarteItem(int itemID, String name, String description, double price, int itemType, Menu menu){
        AlaCarteItem itemToBeEdited = (AlaCarteItem) menu.getItem(itemID);

        if(!name.equals("-1")) itemToBeEdited.setName(name);
        if(!description.equals("-1")) itemToBeEdited.setDescription(description);
        if(price != -1) itemToBeEdited.setPrice(price);
        if(price != -1) itemToBeEdited.setItemType(itemType);
        
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

    public static void removeItem(int itemID, Menu menu){
        MenuItem itemToBeRemoved = menu.getItem(itemID);
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


}
