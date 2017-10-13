package com.revature.service;

import com.revature.bean.BankAccount;
import com.revature.bean.BankUser;
import com.revature.dao.BankDAO;
import com.revature.dao.BankImpl;
import com.revature.dto.BankUserDTO;

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
	
	
	public BankUserDTO convertToBankUserDTO(BankUser user, BankAccount bankAccount){
		
		return new BankUserDTO(user.getId(),user.getUsername(),
				user.getFirstName(),
				user.getLastName(), 
				bankAccount.getBaId(), 
				bankAccount.getBaBalance());
		
	} 
	
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public BankAccount getBankAccountByUsername(BankUser user) {
		//merge all information into a JSON 
		return new BankImpl().getBankAccountByUserId(user);
		
	}

}
