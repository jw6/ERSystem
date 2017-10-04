package com.revature.dao;

import java.util.List;

import com.revature.models.BankAccount;
import com.revature.models.BankTransaction;
import com.revature.models.BankUser;
import com.revature.models.RegisterUser;

public interface BankingDAO {
	/*
	 * CRUD operations only
	 */
	//Create a new user
	public BankUser register(RegisterUser user);
	//User can login
	public BankUser userLogin (String username, String password);
	//User can perform deposit and withdrawal
	public int performTransaction(BankTransaction bt);

	//Create an account
	public void createAccount(int BankUserID);
	
	//This should returns a list of users only names
	public List<BankAccount> getBankAccountByUser(BankUser user);
	
	public int getBankUserID(RegisterUser user);
}
