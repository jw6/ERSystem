package com.revature.bean;

import java.io.Serializable;

public class ERSUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1736047078183400086L;
	
	private int ersId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int rtId;
	private String email;
	
	public ERSUser() {
		super();
	}
	
	//For validate user from login page
	public ERSUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	//For register User since ers id will trigger in sequence
	public ERSUser(String firstName, String lastName, String username, String password, int rtId, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.rtId = rtId;
		this.email = email;
	}

	//For retrieve user data from database
	public ERSUser(int ersId, String firstName, String lastName, String username, String password, int rtId,
			String email) {
		super();
		this.ersId = ersId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.rtId = rtId;
		this.email = email;
	}

	public int getErsId() {
		return ersId;
	}

	public void setErsId(int ersId) {
		this.ersId = ersId;
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

	public int getRtId() {
		return rtId;
	}

	public void setRtId(int rtId) {
		this.rtId = rtId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ERSUser [ersId=" + ersId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", rtId=" + rtId + ", email=" + email + "]";
	}
}
