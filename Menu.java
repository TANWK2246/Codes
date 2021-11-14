import java.util.ArrayList;
import java.io.Serializable;

/**
 * The type Menu which stores an array list of all menu items.
 */
public class Menu implements Serializable {
	/**
	 * The Menu items.
	 */
	private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	/**
	 * The No of ala carte items.
	 */
	private int noOfAlaCarteItems = 0;

	/**
	 * Instantiates a new Menu.
	 */
	public Menu(){}

	/**
	 * Load menu.
	 */
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

	/**
	 * Display menu.
	 */
	public void displayMenu() {
		StringAlignUtils util = new StringAlignUtils(80, StringAlignUtils.Alignment.CENTER);
    	System.out.println( util.format("Ala Carte Menu") );

		displayAlaCarteMenu();
		System.out.println();
		System.out.println(util.format("Set Package Menu"));
		displaySetPackageMenu();
    }

	/**
	 * Display ala carte menu.
	 */
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

	/**
	 * Display set package menu.
	 */
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

	/**
	 * Gets the array list of menu items.
	 *
	 * @return the array list of menu items
	 */
	public ArrayList<MenuItem> getMenuItems() {
		return this.menuItems;
	}

	
	/**
	 * Gets no of ala carte items.
	 *
	 * @return the no of ala carte items
	 */
	public int getNoOfAlaCarteItems() {
		return this.noOfAlaCarteItems;
	}

	
	/**
	 * Sets no of ala carte items.
	 *
	 * @param noOfAlaCarteItems the no of ala carte items
	 */
	public void setNoOfAlaCarteItems(int noOfAlaCarteItems) {
		this.noOfAlaCarteItems = noOfAlaCarteItems;
	}

}
