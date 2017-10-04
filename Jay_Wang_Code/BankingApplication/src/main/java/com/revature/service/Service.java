package com.revature.service;

import java.util.List;

import com.revature.dao.BankingDAOImpl;
import com.revature.models.BankAccount;
import com.revature.models.BankTransaction;
import com.revature.models.BankUser;
import com.revature.models.RegisterUser;

public class Service {
	BankingDAOImpl service = new BankingDAOImpl();
	
	public BankUser userLogin(String username, String password) {
		return service.userLogin(username, password);
	}
	
	public List<BankAccount> getBankAccountByUser(BankUser user) {
		return service.getBankAccountByUser(user);
	}
	
	public void performTransaction(BankTransaction bt) {
		service.performTransaction(bt);
	}
	
	public int getUserID() {
		return 0;
	}
	
	public BankUser register(RegisterUser user) {
		return service.register(user);
	}
	
	public int getBankUserID(RegisterUser user) {
		return service.getBankUserID(user);
	}
	
	public int createRegister(RegisterUser user) {
		return service.getBankUserID(user);
	}
	
	public void createAccount(int BankUserID) {
		service.createAccount(BankUserID);
	}
}
