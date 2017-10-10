package com.revature.models;

public class Employee {
	private String firstName;
	private String lastName;
	private int systemID;
	private int reimbursementID;
	private String email;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, int systemID, int reimbursementID, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.systemID = systemID;
		this.reimbursementID = reimbursementID;
		this.email = email;
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
	public int getSystemID() {
		return systemID;
	}
	public void setSystemID(int systemID) {
		this.systemID = systemID;
	}
	public int getReimbursementID() {
		return reimbursementID;
	}
	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", systemID=" + systemID
				+ ", reimbursementID=" + reimbursementID + ", email=" + email + "]";
	}

	
	
}
