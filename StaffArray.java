import java.util.ArrayList;
import java.io.Serializable;

/**
 * The type Staff array.
 */
public class StaffArray implements Serializable{
	/**
	 * The Staffs.
	 */
	private ArrayList<Staff> staffs = new ArrayList<Staff>();

	/**
	 * Instantiates a new Staff array.
	 */
	public StaffArray(){}

	/**
	 * Load staff.
	 */
	public void loadStaff(){
		staffs.add(new Staff(10001, "Andy", Gender.Male, JobTitle.Waiter));
		staffs.add(new Staff(10002, "Gary", Gender.Male, JobTitle.Waiter));
		staffs.add(new Staff(10003, "Susan", Gender.Female, JobTitle.Waiter));
	}

	/**
	 * Get array list of staffs
	 * 
	 * @return array list of staffs
	 */
	public ArrayList<Staff> getStaffs(){
		return this.staffs;
	}

}