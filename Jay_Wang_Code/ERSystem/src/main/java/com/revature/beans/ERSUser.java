package com.revature.beans;

public class ERSUser {
	private int userID;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private int roleId;
	
	public ERSUser() {
		super();
	}
	
	public ERSUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public ERSUser(int userID, String username, String password, String email, String firstName, String lastName, int roleId) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = roleId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "ERSUser [userID=" + userID + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", roleId=" + roleId + "]";
	}
}
