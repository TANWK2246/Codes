import java.io.Serializable;

/**
 * The type Staff.
 */
public class Staff implements Serializable{
	/**
	 * The Staff id.
	 */
	private int staffID;
	/**
	 * The Name.
	 */
	private String name;
	/**
	 * The Gender.
	 */
	private Gender gender;
	/**
	 * The Job title.
	 */
	private JobTitle jobTitle;

	/**
	 * Instantiates a new Staff.
	 */
	public Staff(){}

	/**
	 * Instantiates a new Staff.
	 *
	 * @param staffID  the staff id
	 * @param name     the name
	 * @param gender   the gender
	 * @param jobTitle the job title
	 */
	public Staff(int staffID, String name, Gender gender, JobTitle jobTitle){
		this.staffID = staffID;
		this.name = name;
		this.gender = gender;
		this.jobTitle = jobTitle;
	}

	/**
	 * Gets staff id.
	 *
	 * @return the staff id
	 */
	public int getStaffID() {
		return this.staffID;
	}

	/**
	 * Sets staff id.
	 *
	 * @param staffID the staff id
	 */
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets gender.
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return this.gender;
	}

	/**
	 * Sets gender.
	 *
	 * @param gender the gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets job title.
	 *
	 * @return the job title
	 */
	public JobTitle getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * Sets job title.
	 *
	 * @param jobTitle the job title
	 */
	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}
}