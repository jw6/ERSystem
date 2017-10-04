package com.revature.models;

public class BankAccount {
	private int 		bankAccountID;
	private double	bankAccountBalance;

	public BankAccount() {
		super();
	}
	
	public BankAccount(int bankAccountID, double bankAccountBalance) {
		super();
		this.bankAccountID = bankAccountID;
		this.bankAccountBalance = bankAccountBalance;
	}

	public int getBankAccountID() {
		return bankAccountID;
	}

	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}

	public double getBankAccountBalance() {
		return bankAccountBalance;
	}

	public void setBankAccountBalance(double bankAccountBalance) {
		this.bankAccountBalance = bankAccountBalance;
	}

	@Override
	public String toString() {
		return "Bank Account with ID number:\t" + bankAccountID + "\tBalance:\t\t" +"$"+bankAccountBalance;
	}
}
