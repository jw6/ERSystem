package com.revature.exceptions;

public class InvalidAmountException extends Exception{
	public InvalidAmountException() {
		System.err.println("This is an invalid input amount.");
	}
}
