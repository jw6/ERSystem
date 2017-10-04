package com.revature.models;

import com.revature.exceptions.UserInfoException;

public class RegisterUser {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public RegisterUser() throws UserInfoException {
		System.err.println("Username and password cannot be empty!");
	}
	
	public RegisterUser(String imcomplete) throws UserInfoException {
		System.err.println("Username or password is missing!");
	}

	public RegisterUser(String firstName, String lastName, String username, String password) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "RegisterUser [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + "]";
	}


}
