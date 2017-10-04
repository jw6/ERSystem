package com.revature.models;

public class BankUser {
	private int		bankUserID;
	private String	firstName;
	private String	lastName;
	private double	balance;
	
	public BankUser() {
		super();
	}

	public BankUser(int bankUserID, String firstName, String lastName) {
		super();
		this.bankUserID = bankUserID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getBankUserID() {
		return bankUserID;
	}

	public void setBankUserID(int bankUserID) {
		this.bankUserID = bankUserID;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		System.out.println("Welcome Login to Main Menu!");
		return "User ID:\t" + bankUserID + ", First Name:\t" + firstName + ", Last Name:\t" + lastName
				;
		//+ ", Current Balance:\t" + "$" + balance
	}
}
