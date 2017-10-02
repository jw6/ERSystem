package com.revature.exceptions;

public class UserInfoException extends Exception{
	public UserInfoException() {
		System.err.println("Username or password is incorrect!");
	}
}
