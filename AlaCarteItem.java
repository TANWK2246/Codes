/**
 * The type Ala carte item.
 */
public class AlaCarteItem extends MenuItem{
	/**
	 * The Item type.
	 */
	private ItemType itemType;

	/**
	 * Instantiates a new Ala carte item.
	 */
	public AlaCarteItem(){}

	/**
	 * Instantiates a new Ala carte item.
	 *
	 * @param name        the name
	 * @param description the description
	 * @param price       the price
	 * @param itemType    the item type
	 */
	public AlaCarteItem(String name, String description, double price, int itemType){
		super( name,  description,  price);
		switch(itemType){
			case 1:
				this.itemType = ItemType.MainCourse;
				break;
			case 2:
				this.itemType = ItemType.Drinks;
				break;
			case 3:
				this.itemType = ItemType.Dessert;
				break;
			case 4:
				this.itemType = ItemType.SideDish;
				break;
		}
		
		System.out.println("AlaCarteItem " + super.getName() + " has been created.");
	}

	/**
	 * Display menu item.
	 */
	public void displayMenuItem(){
		String formatInfo = "%-20.20s %-30.30s S$ %7.2f\t\t%-10.10s\n";
		System.out.format(formatInfo, super.getName(), super.getDescription(), super.getPrice(), this.itemType);
	};

	/**
	 * Set item type.
	 *
	 * @param itemType the item type
	 */
	public void setItemType(int itemType){
		switch(itemType){
			case 1:
				this.itemType = ItemType.MainCourse;
				break;
			case 2:
				this.itemType = ItemType.Drinks;
				break;
			case 3:
				this.itemType = ItemType.Dessert;
				break;
			case 4:
				this.itemType = ItemType.SideDish;
				break;
		}
	}
}