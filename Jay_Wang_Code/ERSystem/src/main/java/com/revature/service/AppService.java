package com.revature.service;

import com.revature.DAO.ErsDAO;
import com.revature.DAO.ErsDAOImpl;
import com.revature.beans.ERSUser;

public class AppService {
	public ERSUser validateUser(ERSUser clientUser) {
		ErsDAO dao = new ErsDAOImpl();
		
		ERSUser dbUser = dao.getUserByUsername(clientUser);
		if(dbUser != null) {
			if(			dbUser.getUsername().equals(clientUser.getUsername())
					&& 	dbUser.getPassword().equals(clientUser.getPassword())		) {
				
				return dbUser;
			}
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		ErsDAO dao = new ErsDAOImpl();
//		ERSUser client = new ERSUser("Dinash", "d123");
//		ERSUser dbUser = dao.getUserByUsername(client);
//		System.out.println(dbUser.toString());
//	}
//	
}
