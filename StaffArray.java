import java.util.ArrayList;
import java.io.Serializable;

public class StaffArray implements Serializable{
	private ArrayList<Staff> staffs = new ArrayList<Staff>();

	public StaffArray(){}

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


	public boolean checkStaffID(int staffID){
		Staff staff = this.getStaff(staffID);
		if(staff == null) return false;
		else return true;
	}

}