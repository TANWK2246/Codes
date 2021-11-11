public class StaffManager{
	public static Staff getStaff(int staffID, StaffArray staffArray){
		return staffArray.getStaff(staffID);
	}

	public static boolean validateStaffID(int staffID, StaffArray staffArray){
		return staffArray.checkStaffID(staffID);
	}

}