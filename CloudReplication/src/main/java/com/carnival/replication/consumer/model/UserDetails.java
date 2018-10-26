package com.carnival.replication.consumer.model;

/**
 * @author E01551
 *
 */
public class UserDetails {
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String pmsBookingId;
	private boolean activeStatus;
	private String userType; // Type of user (crew/PMS User)

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPmsBookingId() {
		return pmsBookingId;
	}

	public void setPmsBookingId(String pmsBookingId) {
		this.pmsBookingId = pmsBookingId;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dob=" + dob + ", pmsBookingId=" + pmsBookingId + ", activeStatus=" + activeStatus + ", userType="
				+ userType + "]";
	}
}