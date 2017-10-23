package com.revature.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount {

	@Id
	@Column(name = "BA_ID")
	private int baNumber;

	@Column(name = "BA_BALANCE")
	private double baBalance;
	
	@ManyToOne
	@JoinColumn(name="U_ID")
	private BankUser bankUser;
	
	@OneToMany(mappedBy = "bankAccount", fetch = FetchType.EAGER)
	Set<BankTransaction> bankTx = new HashSet<BankTransaction>();

	public BankAccount() {
		
	}

	public BankAccount(int baNumber, double baBalance, BankUser bankUser, Set<BankTransaction> bankTx) {
		super();
		this.baNumber = baNumber;
		this.baBalance = baBalance;
		this.bankUser = bankUser;
		this.bankTx = bankTx;
	}

	public int getBaNumber() {
		return baNumber;
	}

	public void setBaNumber(int baNumber) {
		this.baNumber = baNumber;
	}

	public double getBaBalance() {
		return baBalance;
	}

	public void setBaBalance(double baBalance) {
		this.baBalance = baBalance;
	}

	public BankUser getBankUser() {
		return bankUser;
	}

	public void setBankUser(BankUser bankUser) {
		this.bankUser = bankUser;
	}

	public Set<BankTransaction> getBankTx() {
		return bankTx;
	}

	public void setBankTx(Set<BankTransaction> bankTx) {
		this.bankTx = bankTx;
	}

	@Override
	public String toString() {
		return "BankAccount [baNumber=" + baNumber + ", baBalance=" + baBalance + ", bankUser="
				+ bankUser + ", bankTx=" + bankTx + "]";
	}

}