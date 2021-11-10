import java.io.Serializable;

public class Staff implements Serializable{
	private int staffID;
	private String name;
	private Gender gender;
	private JobTitle jobTitle;

	public Staff(){}

	public Staff(int staffID, String name, Gender gender, JobTitle jobTitle){
		this.staffID = staffID;
		this.name = name;
		this.gender = gender;
		this.jobTitle = jobTitle;
	}

	public int getStaffID() {
		return this.staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public JobTitle getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}
}