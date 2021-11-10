import java.util.ArrayList;
import java.io.Serializable;

public class StaffManager implements Serializable{
	private ArrayList<Staff> staffs = new ArrayList<Staff>();

	public StaffManager(){
		
	}

	public void loadStaff(){
		staffs.add(new Staff(10001, "Andy", Gender.Male, JobTitle.Waiter));
		staffs.add(new Staff(10002, "Gary", Gender.Male, JobTitle.Waiter));
		staffs.add(new Staff(10003, "Susan", Gender.Female, JobTitle.Waiter));
	}

	public Staff getStaff(int staffID){
		for(Staff i : staffs){
			if(i.getStaffID() == staffID) return i;
		}
		return null;
	}

	public void printStaff(){
		System.out.println("Staff name list:");
		for(Staff i: staffs){
			System.out.println(i.getName());
		}
	}

	public void addStaff() {
		throw new UnsupportedOperationException();
	}

	public void editStaff() {
		throw new UnsupportedOperationException();
	}

	public void removeStaff() {
		throw new UnsupportedOperationException();
	}
}