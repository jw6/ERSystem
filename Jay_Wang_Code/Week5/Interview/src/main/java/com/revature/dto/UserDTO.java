package com.revature.dto;

import java.io.Serializable;

import com.revature.bean.HagenRanchUser;

public class UserDTO extends HagenRanchUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	
	public UserDTO() {
		super();
	}

	public UserDTO(int id, String firstname, String lastname, String username, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
	}

	public UserDTO(int userId, String firstName, String lastName, String username, String password, int roleId,
			String email) {
		super(userId, firstName, lastName, username, password, roleId, email);
		this.id = userId;
		this.firstname = firstName;
		this.lastname = lastName;
		this.username = username;
		this.email = email;
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
}
