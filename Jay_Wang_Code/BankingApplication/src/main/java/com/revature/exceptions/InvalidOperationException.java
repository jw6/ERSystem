package com.revature.exceptions;

public class InvalidOperationException extends Exception{
	public InvalidOperationException() {
		System.err.println("Invalid operation, please choose between deposit and withdraw.");
	}
}
