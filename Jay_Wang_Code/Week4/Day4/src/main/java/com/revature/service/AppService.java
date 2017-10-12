package com.revature.service;

import com.revature.bean.BankUser;
import com.revature.dao.BankDAO;
import com.revature.dao.BankImpl;

public class AppService {
	public BankUser validateUser(BankUser clientUser) {
		BankDAO dao = new BankImpl();
		
		BankUser dbUser = dao.getUserByUsername(clientUser);
		if(dbUser != null) {
			//compare the passwords
			if(dbUser.getUsername().equals(clientUser.getUsername()) &&
					dbUser.getPassword().equals(clientUser.getPassword())) {
				return dbUser;
			}
		}
	return null;
	}
	
}
