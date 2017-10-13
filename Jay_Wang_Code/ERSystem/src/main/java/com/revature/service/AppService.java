package com.revature.service;

import com.revature.DAO.ErsDAO;
import com.revature.DAO.ErsDAOImpl;
import com.revature.beans.ERSUser;

public class AppService {
	public ERSUser validateUser(ERSUser clientUser) {
		ErsDAO dao = new ErsDAOImpl();
		
		ERSUser dbUser = dao.getUserByUsername(clientUser);
		if(dbUser != null) {
			if(dbUser.getUsername().equals(clientUser.getUsername())
					&& dbUser.getPassword().equals(clientUser.getPassword())) {
				return dbUser;
			}
		}
		return null;
	}
	
}
