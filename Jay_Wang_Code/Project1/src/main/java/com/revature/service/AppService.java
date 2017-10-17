package com.revature.service;

import com.revature.bean.ERSUser;
import com.revature.dao.DAO;
import com.revature.dao.DAOImpl;

public class AppService {
	public ERSUser validateUser(ERSUser clientUser) {
		DAO dao = new DAOImpl();
		
		ERSUser dbUser = dao.getUserByUsername(clientUser);
		if(dbUser != null) {
			if(			dbUser.getUsername().equals(clientUser.getUsername())
					&& 	dbUser.getPassword().equals(clientUser.getPassword())		) {
				
				return dbUser;
			}
		}
		return null;
	}
}
