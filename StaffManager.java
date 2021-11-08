import java.util.ArrayList;

public class StaffManager {
	private ArrayList<Staff> staffs = new ArrayList<Staff>();

	public StaffManager(){
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