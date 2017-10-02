package com.revature.models;

public class BankUser {
	private int		bankUserID;
	private String	firstName;
	private String	lastName;
	private double	balance;
	
	public BankUser() {
		super();
	}

	public BankUser(int bankUserID, String firstName, String lastName, double balance) {
		super();
		this.bankUserID = bankUserID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
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
		return "BankUser [bankUserID=" + bankUserID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", balance=" + balance + "]";
	}
}
