package com.revature.dao;

import java.util.List;

import com.revature.models.BankAccount;
import com.revature.models.BankTransaction;
import com.revature.models.BankUser;

public class BankingDAOImpl implements BankingDAO {

	@Override
	public BankUser getBankUserInfo(String username, String password) {
		
		return null;
	}

	@Override
	public List<BankAccount> getBankAccount(BankUser bankUser) {
		return null;
	}

	@Override
	public boolean completeTransaction(BankTransaction bankTx) {
		return false;
	}

}
