import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private ArrayList<AlaCarteItem> alaCarteItems = new ArrayList<AlaCarteItem>();
	private ArrayList<SetPackage> setPackageItems = new ArrayList<SetPackage>();

	public Menu(){
		this.alaCarteItems.add(new AlaCarteItem("Chicken Chop", "chicken", 12.50, ItemType.MainCourse));
		this.alaCarteItems.add(new AlaCarteItem("Fish and Chips", "fish & potato", 12.50, ItemType.MainCourse));
		this.alaCarteItems.add(new AlaCarteItem("Orang Juice", "orange", 8.00, ItemType.Drinks));
		this.alaCarteItems.add(new AlaCarteItem("French Fries", "potato", 10.00, ItemType.SideDish));
		this.alaCarteItems.add(new AlaCarteItem("Lava cake", "chocolate", 10.00, ItemType.Dessert));

		SetPackage newSetPackage = new SetPackage("Lunch Set for One", "lunch for one pax", 25.00);
		newSetPackage.addItem(this.alaCarteItems.get(0));
		newSetPackage.addItem(this.alaCarteItems.get(2));
		newSetPackage.addItem(this.alaCarteItems.get(3));

		this.setPackageItems.add(newSetPackage);

		newSetPackage = new SetPackage("Lunch Set for Two", "lunch for two pax", 45.00);
		newSetPackage.addItem(this.alaCarteItems.get(0));
		newSetPackage.addItem(this.alaCarteItems.get(0));
		newSetPackage.addItem(this.alaCarteItems.get(2));
		newSetPackage.addItem(this.alaCarteItems.get(2));
		newSetPackage.addItem(this.alaCarteItems.get(3));
		newSetPackage.addItem(this.alaCarteItems.get(3));

		this.setPackageItems.add(newSetPackage);
	}

	public void displayMenu() {
		System.out.println("Ala Carte Menu");
		this.displayAlaCarteMenu();
		System.out.println("Set Package Menu");
		this.displaySetPackageMenu();
    }

	public void displayAlaCarteMenu(){
		int counter = 0;
		for (AlaCarteItem i : alaCarteItems) {
			System.out.printf("%d\t", counter);
			i.displayMenuItem();
			counter++;
		}
	}

	public void displaySetPackageMenu(){
		int counter = 0;
		for (SetPackage i : setPackageItems) {
			System.out.printf("%d\t", counter);
			i.displayMenuItem();
			counter++;
		}
	}

	public MenuItem getAlaCarteItem(int itemID){
		return this.alaCarteItems.get(itemID);
	}

	public MenuItem getSetPackage(int itemID){
		return this.setPackageItems.get(itemID);
	}

	public void editMenu(){
		int choice;
		AlaCarteItem newItem;
		String name, description;
		double price;
		int itemType, itemID;
		Scanner sc = new Scanner(System.in);
		do{
            System.out.println("Menu editing:");
            System.out.println("1: Add Ala Carte Item");
            System.out.println("2: Edit Ala Carte Item");
            System.out.println("3: Remove Ala Carte Item");
            System.out.println("4: Add Set Package");
            System.out.println("5: Edit Set Package");
            System.out.println("6: Remove Set Package");
            System.out.println("7: Done");
			choice = sc.nextInt();
            
			switch (choice) {
                case 1:
					System.out.println("Enter Item Name:");
					sc.nextLine();
					name = sc.nextLine();
					System.out.println("Enter Item Description:");
					description = sc.nextLine();
					System.out.println("Enter Item Price:");
					price = sc.nextDouble();
					System.out.println("Enter Item Type: (1) MainCourse (2) Drinks (3) Dessert (4) SideDish");
					itemType = sc.nextInt();
					switch(itemType){
						case 1:
							newItem = new AlaCarteItem(name, description, price, ItemType.MainCourse);
							this.alaCarteItems.add(newItem);newItem.displayMenuItem();
							break;
						case 2:
							newItem = new AlaCarteItem(name, description, price, ItemType.Drinks);
							this.alaCarteItems.add(newItem);newItem.displayMenuItem();
							break;
						case 3:
							newItem = new AlaCarteItem(name, description, price, ItemType.Drinks);
							this.alaCarteItems.add(newItem);newItem.displayMenuItem();
							break;
						case 4:
							newItem = new AlaCarteItem(name, description, price, ItemType.SideDish);
							this.alaCarteItems.add(newItem);newItem.displayMenuItem();
							break;
					}
					
                    break;
                case 2: 
					this.displayAlaCarteMenu();
					System.out.println("Enter the itemID to be edited:");
                    itemID = sc.nextInt();
					AlaCarteItem itemToBeEdited = this.alaCarteItems.get(itemID);
					System.out.println("Enter Item Name: (or -1 to skip)");
					sc.nextLine();
					name = sc.nextLine();
					if(!name.equals("-1")) itemToBeEdited.setName(name);
					System.out.println("Enter Item Description: (or -1 to skip)");
					description = sc.nextLine();
					if(!description.equals("-1")) itemToBeEdited.setDescription(description);
					System.out.println("Enter Item Price: (or -1 to skip)");
					price = sc.nextDouble();
					if(price != -1) itemToBeEdited.setPrice(price);
					System.out.println("Enter Item Type: (1) MainCourse (2) Drinks (3) Dessert (4) SideDish (-1) Skip");
					itemType = sc.nextInt();
					switch(itemType){
						case 1:
							itemToBeEdited.setItemType(ItemType.MainCourse);
							break;
						case 2:
							itemToBeEdited.setItemType(ItemType.Drinks);
							break;
						case 3:
							itemToBeEdited.setItemType(ItemType.Dessert);
							break;
						case 4:
							itemToBeEdited.setItemType(ItemType.SideDish);
							break;
					}
					System.out.println("AlaCarteItem " + itemToBeEdited.getName() + " has been edited.");
					itemToBeEdited.displayMenuItem();
                    break;
                case 3:
					this.displayAlaCarteMenu();
					System.out.println("Enter the itemID to be removed:");
					itemID = sc.nextInt();
					AlaCarteItem itemToBeRemoved = this.alaCarteItems.remove(itemID);
					System.out.println("AlaCarteItem " + itemToBeRemoved.getName() + " has been removed.");
                    break;
                case 4: 
					SetPackage newPackage;
					System.out.println("Enter Set Package Name:");
					sc.nextLine(); name = sc.nextLine();
					System.out.println("Enter Set Package Description:");
					description = sc.nextLine();
					System.out.println("Enter Set Package Price:");
					price = sc.nextDouble();
					newPackage = new SetPackage(name, description, price);
					this.displayAlaCarteMenu();
					System.out.println("Add item into the package, enter (-1) to end");

					System.out.println("\tEnter itemID:");
					itemID = sc.nextInt();
					while (itemID != -1){
						newPackage.addItem(this.alaCarteItems.get(itemID));
						System.out.println("\tEnter itemID:");
						itemID = sc.nextInt();
					}
					this.setPackageItems.add(newPackage);
					newPackage.displayMenuItem();
                    break;
                case 5:
					this.displaySetPackageMenu();
					System.out.println("Enter the itemID to be edited:");
					itemID = sc.nextInt();
					SetPackage setPackageToBeEdited = this.setPackageItems.get(itemID);
					System.out.println("Enter Set Package Name: (or -1 to skip)");
					sc.nextLine();
					name = sc.nextLine();
					if(!name.equals("-1")) setPackageToBeEdited.setName(name);
					System.out.println("Enter Set Package Description: (or -1 to skip)");
					description = sc.nextLine();
					if(!description.equals("-1")) setPackageToBeEdited.setDescription(description);
					System.out.println("Enter Set Package Price: (or -1 to skip)");
					price = sc.nextDouble();
					if(price != -1) setPackageToBeEdited.setPrice(price);
                    
					this.displayAlaCarteMenu();

					System.out.println("Add item into the package, enter (-1) to end");

					System.out.println("\tEnter itemID:");
					itemID = sc.nextInt();
					while (itemID != -1){
						setPackageToBeEdited.addItem(this.alaCarteItems.get(itemID));
						System.out.println("\tEnter itemID:");
						itemID = sc.nextInt();
					}

					System.out.println("Remove item from the package, enter(-1) to end");

					System.out.println("\tEnter itemID:");
					itemID = sc.nextInt();
					while (itemID != -1){
						setPackageToBeEdited.removeItem(this.alaCarteItems.get(itemID));
						System.out.println("\tEnter itemID:");
						itemID = sc.nextInt();
					}
					
					System.out.println("SetPackage " + setPackageToBeEdited.getName() + " has been edited.");
					setPackageToBeEdited.displayMenuItem();
					break;
					
                case 6:
					this.displaySetPackageMenu();
					System.out.println("Enter the itemID to be removed:");
					itemID = sc.nextInt();
					SetPackage setPackageToBeRemoved = this.setPackageItems.remove(itemID);
					System.out.println("SetPackageItem " + setPackageToBeRemoved.getName() + " has been removed.");
                    break;
                case 7: System.out.println("Done editing, Back to Homepage...");
            }

        }while (choice < 7);
	}

}
