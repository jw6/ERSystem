package com.revature.models;

import java.util.Date;

public class BankTransaction {
	private int		transactionID;
	private int		BankAccountID;
	private int		transactionType;
	
	private double	transactionAmount;
	private Date		transacationDate;
	
	/*
	 * Use Singleton DP to create a enum type
	 * 1 stands for deposit, 2 stands for withdraw
	 * 
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
}
