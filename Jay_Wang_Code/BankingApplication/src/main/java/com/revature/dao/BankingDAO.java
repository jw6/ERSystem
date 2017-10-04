package com.revature.dao;

import java.util.List;

import com.revature.models.BankAccount;
import com.revature.models.BankTransaction;
import com.revature.models.BankUser;

public interface BankingDAO {
	/*
	 * CRUD operations only
	 */
	//User can login
	public BankUser userLogin (String username, String password);
	//User can perform deposit and withdrawal
	public int performTransaction(BankTransaction bt);

	//Bonus parts
	public boolean transactionOnRecord();
	public void transactionHistory();
	public BankUser registerUser(String firstName, String lastName, String username, String password);
	
	//This should returns a list of users only names
	public List<BankAccount> getBankAccountByUser(BankUser user);
	
}
