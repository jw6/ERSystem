package com.revature.bean;

import java.io.Serializable;

/**
 * 
 * @author jay
 *
 */
public class HagenRanchUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private int userId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int roleId;
	private String email;
	
	public HagenRanchUser() {
		super();
	}
	
	public HagenRanchUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public HagenRanchUser(int userId, String firstName, String lastName, String username, String password,
			int roleType) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.roleId = roleType;
	}
	

	public HagenRanchUser(int userId, String firstName, String lastName, String username, String password, int roleId,
			String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
		return "HagenRanchUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + ", roleType=" + roleId + ", email=" + email
				+ "]";
	}
}
