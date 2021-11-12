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
		String formatInfo = "%-20.20s %-30.30s S$ %7.2f\t\n";
		System.out.format(formatInfo, super.getName(), super.getDescription(), super.getPrice());

		formatInfo = "\t%-20.20s %-30.30s\n";
		for (AlaCarteItem i : items) {
			System.out.format(formatInfo, i.getName(), i.getDescription());
			
		}	
	};
}