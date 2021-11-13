import java.util.ArrayList;
import java.io.Serializable;

public class Menu implements Serializable {
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	private int noOfAlaCarteItems = 0;

	public Menu(){}

	public void loadMenu(){
		menuItems.add(new AlaCarteItem("Chicken Chop", "chicken", 12.50, 1));noOfAlaCarteItems++;
		menuItems.add(new AlaCarteItem("Fish and Chips", "fish & potato", 12.50, 1));noOfAlaCarteItems++;
		menuItems.add(new AlaCarteItem("Orange Juice", "orange", 8.00, 2));noOfAlaCarteItems++;
		menuItems.add(new AlaCarteItem("French Fries", "potato", 10.00, 3));noOfAlaCarteItems++;
		menuItems.add(new AlaCarteItem("Lava cake", "chocolate", 10.00, 4));noOfAlaCarteItems++;

		SetPackage newSetPackage = new SetPackage("Lunch Set for One", "lunch for one pax", 25.00);
		newSetPackage.addItem((AlaCarteItem) menuItems.get(0));
		newSetPackage.addItem((AlaCarteItem) menuItems.get(2));
		newSetPackage.addItem((AlaCarteItem) menuItems.get(3));

		menuItems.add(newSetPackage);

		newSetPackage = new SetPackage("Lunch Set for Two", "lunch for two pax", 45.00);
		newSetPackage.addItem((AlaCarteItem) menuItems.get(0));
		newSetPackage.addItem((AlaCarteItem) menuItems.get(0));
		newSetPackage.addItem((AlaCarteItem) menuItems.get(2));
		newSetPackage.addItem((AlaCarteItem) menuItems.get(2));
		newSetPackage.addItem((AlaCarteItem) menuItems.get(3));
		newSetPackage.addItem((AlaCarteItem) menuItems.get(3));

		menuItems.add(newSetPackage);
	}

	public void displayMenu() {
		StringAlignUtils util = new StringAlignUtils(80, StringAlignUtils.Alignment.CENTER);
    	System.out.println( util.format("Ala Carte Menu") );

		displayAlaCarteMenu();
		System.out.println();
		System.out.println(util.format("Set Package Menu"));
		displaySetPackageMenu();
    }

	public void displayAlaCarteMenu(){
		String formatInfo = "%s\t%-20.20s %-30.30s %-9.9s\t\t%-10.10s\n";
		System.out.format(formatInfo,"ID", "Name", "Description", "Price", "Type");

		int counter = 0;
		while(counter < noOfAlaCarteItems){
			System.out.printf("%d\t", counter);
			menuItems.get(counter).displayMenuItem();
			counter++;
		}
	}

	public void displaySetPackageMenu(){
		String formatInfo = "%s\t%-20.20s %-30.30s %-9.9s\t\n";
		System.out.format(formatInfo,"ID", "Name", "Description", "Price");

		int counter = noOfAlaCarteItems;
		while(counter < menuItems.size()){
			System.out.printf("%d\t", counter);
			menuItems.get(counter).displayMenuItem();
			counter++;
		}
	}

	public MenuItem getItem(int itemID){
		return menuItems.get(itemID);
	}

	public void addItem(AlaCarteItem menuItem){
		menuItems.add(noOfAlaCarteItems, menuItem);
		noOfAlaCarteItems++;
	}

	public void removeItem(AlaCarteItem menuItem){
		menuItems.remove(menuItem);
		noOfAlaCarteItems--;
	}

	public void addItem(SetPackage menuItem){
		menuItems.add(menuItem);
	}

	public void removeItem(SetPackage menuItem){
		menuItems.remove(menuItem);
	}

	public ArrayList<MenuItem> getMenuItems() {
		return this.menuItems;
	}

	public int getNoOfAlaCarteItems() {
		return this.noOfAlaCarteItems;
	}

}
