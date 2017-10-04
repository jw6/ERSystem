package com.revature.models;

import java.util.Date;

import com.revature.exceptions.InvalidOperationException;

public class BankTransaction {
	private int		transactionID;
	private int		bankAccountID;
	private int		transactionType;
	
	private double	transactionAmount;
	private Date		transactionDate;
	
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
	public BankTransaction(int bankAccountID, int transactionType, double transactionAmount, Date transactionDate) {
		this.transactionID = -1;
		this.bankAccountID = bankAccountID;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}
	
	public BankTransaction(int transactionID, int bankAccountID, int transactionType, double transactionAmount,
			Date transactionDate) {
		super();
		this.transactionID = transactionID;
		this.bankAccountID = bankAccountID;

		try {
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
		} catch (InvalidOperationException e) {
			e.printStackTrace();
		}
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
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
		return transactionDate;
	}
	public void setTransacationDate(Date transacationDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public String toString() {
		return "Transaction with transactino ID:\t" + transactionID + ", Account ID:\t" + bankAccountID
				+ ", transaction Type\t" + transactionType + ", transaction Amount:\t" + transactionAmount
				+ ", transaction Date\t" + transactionDate;
	}
}
