public class AlaCarteItem extends MenuItem{
	private ItemType itemType;

	public AlaCarteItem(){}

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

	public void displayMenuItem(){
		System.out.print(super.getName() + "\t" + super.getDescription()+ "\t$" + String.format("%,.2f", super.getPrice()));
		System.out.println("\t" + this.itemType);
	};

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