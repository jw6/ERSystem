package com.revature.models;

public class Manager {
	private String firstName;
	private String lastName;
	private int systemID;
	private int reimbursementID;
	private String email;
	
	public Manager() {
		super();
	}
	
	public Manager(String firstName, String lastName, int systemID, int reimbursementID, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.systemID = systemID;
		this.reimbursementID = reimbursementID;
		this.email = email;
	}
	
}
