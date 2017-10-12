package com.revature.bean;

public class BankAccount {
	private int baId;
	private double baBalance;
	private int baUserId;
	public BankAccount() {
		super();
	}
	public int getBaId() {
		return baId;
	}
	public void setBaId(int baId) {
		this.baId = baId;
	}
	public double getBaBalance() {
		return baBalance;
	}
	public void setBaBalance(double baBalance) {
		this.baBalance = baBalance;
	}
	public int getBaUserId() {
		return baUserId;
	}
	public void setBaUserId(int baUserId) {
		this.baUserId = baUserId;
	}
	
	
}
