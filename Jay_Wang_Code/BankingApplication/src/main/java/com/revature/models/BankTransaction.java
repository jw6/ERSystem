package com.revature.models;

import java.util.Date;

import com.revature.exceptions.InvalidOperationException;

public class BankTransaction {
	private int		transactionID;
	private int		bankAccountID;
	private int		transactionType;
	
	private double	transactionAmount;
	private Date		transacationDate;
	
	/*
	 * Use Singleton DP to create a enum type
	 * 1 stands for deposit, 2 stands for withdraw 
	 */
	private enum TransactionType {
		DEPOSIT(1),	WITHDRAW(2);
		private final int value;
		private TransactionType(int value) {
			this.value = value;
		}
		public int getType() {
			return value;
		}
	}
	/*
	 * Created for testing enum returns correct values
	 */
//	public static void main(String[] args) {
//		System.out.println(TransactionType.DEPOSIT.getType());
//		System.out.println(TransactionType.WITHDRAW.getType());
//	}

	public BankTransaction() {
		super();
	}
	public BankTransaction(int bankAccountID, int transactionType, double transactionAmount, Date transacationDate) {
		this.transactionID = -1;
		this.bankAccountID = bankAccountID;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transacationDate = transacationDate;
	}
	
	public BankTransaction(int transactionID, int bankAccountID, int transactionType, double transactionAmount,
			Date transacationDate) throws InvalidOperationException{
		super();
		this.transactionID = transactionID;
		this.bankAccountID = bankAccountID;
		switch(transactionType) {
		case 1:
			this.transactionType = TransactionType.DEPOSIT.getType();
			break;
		case 2:
			this.transactionType = TransactionType.WITHDRAW.getType();
			break;
		default:
			throw new InvalidOperationException();
		}
		this.transactionAmount = transactionAmount;
		this.transacationDate = transacationDate;
	}
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getBankAccountID() {
		return bankAccountID;
	}
	public void setBankAccountID(int bankAccountID) {
		this.bankAccountID = bankAccountID;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Date getTransacationDate() {
		return transacationDate;
	}
	public void setTransacationDate(Date transacationDate) {
		this.transacationDate = transacationDate;
	}
	@Override
	public String toString() {
		return "BankTransaction [transactionID=" + transactionID + ", bankAccountID=" + bankAccountID
				+ ", transactionType=" + transactionType + ", transactionAmount=" + transactionAmount
				+ ", transacationDate=" + transacationDate + "]";
	}
}
