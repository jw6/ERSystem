package com.revature.dao;

import java.util.List;

import com.revature.models.BankAccount;
import com.revature.models.BankTransaction;
import com.revature.models.BankUser;

public interface BankingDAO {
	public BankUser getBankUserInfo(String username, String password);
	public List<BankAccount> getBankAccount(BankUser bankUser);
	public boolean completeTransaction(BankTransaction bankTx);
}
