public class AlaCarteItem extends MenuItem{
	private ItemType itemType;

	public AlaCarteItem(){}

	public AlaCarteItem(String name, String description, double price, ItemType itemType){
		super( name,  description,  price);
		this.itemType = itemType;
		System.out.println("AlaCarteItem " + super.getName() + " has been created.");
	}

	public void displayMenuItem(){
		super.displayMenuItem();
		System.out.println("\t" + this.itemType);
	};

	public ItemType getItemType() {
		return this.itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
}