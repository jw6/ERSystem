package com.revature.models;

import com.revature.exceptions.UserInfoException;

public class UserLoginInfo {
	private String username;
	private String password;
	
	public UserLoginInfo() throws UserInfoException {
		System.err.println("Username and password cannot be empty!");
	}
	
	public UserLoginInfo(String imcomplete) throws UserInfoException {
		System.err.println("Username or password is missing!");
	}
	
	public UserLoginInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
		return "UserLoginInfo [username=" + username + ", password=" + password + "]";
	}
}
