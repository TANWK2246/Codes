import java.util.ArrayList;

public class SetPackage extends MenuItem {
	private ArrayList<AlaCarteItem> items = new ArrayList<AlaCarteItem>();

	public SetPackage(){}

	public SetPackage(String name, String description, double price){
		super( name,  description,  price);
		System.out.println("SetPackage " + super.getName() + " has been created.");
	}

	public void addItem(AlaCarteItem item){
		this.items.add(item);
	}

	public void removeItem(AlaCarteItem item){
		this.items.remove(item);
	}

	public void displayMenuItem(){
		super.displayMenuItem();
		System.out.println();
		for (AlaCarteItem i : items) {
			System.out.println("\t" + i.getName() + "\t" + i.getDescription());
		}	
	};
}