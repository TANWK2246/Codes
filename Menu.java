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
		System.out.println("Ala Carte Menu");
		displayAlaCarteMenu();
		System.out.println("Set Package Menu");
		displaySetPackageMenu();
    }

	public void displayAlaCarteMenu(){
		int counter = 0;
		while(counter < noOfAlaCarteItems){
			System.out.printf("%d\t", counter);
			menuItems.get(counter).displayMenuItem();
			counter++;
		}
	}

	public void displaySetPackageMenu(){
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

	public void addItem(MenuItem menuItem){
		menuItems.add(noOfAlaCarteItems, menuItem);
		noOfAlaCarteItems++;
	}

	public void removeItem(MenuItem menuItem){
		menuItems.remove(menuItem);
		noOfAlaCarteItems--;
	}

}
