package com.revature.dao;

import com.revature.bean.BankAccount;
import com.revature.bean.BankUser;

public interface BankDAO {

	//Create
	
	//Read
	public BankUser getUserByUsername(BankUser user);
	public BankAccount getBankAccountByUserId(BankUser user);
	//Update
	
	//Delete
	
}
