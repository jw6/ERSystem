package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BANK_TX")
public class BankTx {
	@Id
	@Column(name="TX_ID")
	private int txNumber;

	@ManyToOne
	@JoinColumn(name="BA_ID")
	private BankAccount bankAccount;

	@ManyToOne
	@JoinColumn(name="BTT_ID")
	private BankTxType bankTxType;

	@Column(name="TX_AMOUNT")
	private double txAmount;

	@Column(name="TX_TIMESTAMP")
	private String txTimestamp;

	public BankTx() {
		super();
	}

	public int getTxNumber() {
		return txNumber;
	}

	public void setTxNumber(int txNumber) {
		this.txNumber = txNumber;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public BankTxType getBankTxType() {
		return bankTxType;
	}

	public void setBankTxType(BankTxType bankTxType) {
		this.bankTxType = bankTxType;
	}

	public double getTxAmount() {
		return txAmount;
	}

	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}

	public String getTxTimestamp() {
		return txTimestamp;
	}

	public void setTxTimestamp(String txTimestamp) {
		this.txTimestamp = txTimestamp;
	}

	@Override
	public String toString() {
		return "BankTx [txNumber=" + txNumber + ", bankAccount=" + bankAccount + ", bankTxType=" + bankTxType
				+ ", txAmount=" + txAmount + ", txTimestamp=" + txTimestamp + "]" +"\n";
	}

}
