import java.util.ArrayList;

/**
 * The type Set package.
 */
public class SetPackage extends MenuItem {
	/**
	 * The Items in the set package.
	 */
	private ArrayList<AlaCarteItem> items = new ArrayList<AlaCarteItem>();

	/**
	 * Instantiates a new Set package.
	 */
	public SetPackage(){}

	/**
	 * Instantiates a new Set package.
	 *
	 * @param name        the name
	 * @param description the description
	 * @param price       the price
	 */
	public SetPackage(String name, String description, double price){
		super( name,  description,  price);
		System.out.println("SetPackage " + super.getName() + " has been created.");
	}

	/**
	 * Add item into the set package.
	 *
	 * @param item the item
	 */
	public void addItem(AlaCarteItem item){
		this.items.add(item);
	}

	/**
	 * Remove item from the set package.
	 *
	 * @param item the item
	 */
	public void removeItem(AlaCarteItem item){
		this.items.remove(item);
	}

	/**
	 * Display menu item.
	 */
	public void displayMenuItem(){
		String formatInfo = "%-20.20s %-30.30s S$ %7.2f\t\n";
		System.out.format(formatInfo, super.getName(), super.getDescription(), super.getPrice());

		formatInfo = "\t%-20.20s %-30.30s\n";
		for (AlaCarteItem i : items) {
			System.out.format(formatInfo, i.getName(), i.getDescription());
		}	
	}

}