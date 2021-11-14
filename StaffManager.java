/**
 * The type Staff manager.
 */
public class StaffManager{
	/**
	 * Validate staff id.
	 *
	 * @param staffID    the staff id
	 * @param staffArray the staff array
	 * @return true if stadd id can match with any staff in the array, or false otherwise
	 */
	public static boolean validateStaffID(int staffID, StaffArray staffArray){
		for(Staff staff : staffArray.getStaffs()){
			if(staff.getStaffID() == staffID) return true;
		}
		return false;
	}

	public static Staff getStaffByID(int staffID, StaffArray staffArray){
		for(Staff staff : staffArray.getStaffs()){
			if(staff.getStaffID() == staffID) return staff;
		}
		return null;
	}

}