package com.revature.service;

import com.revature.bean.ERSUser;
import com.revature.bean.Reimbursement;
import com.revature.dao.DAO;
import com.revature.dao.DAOImpl;

public class AppService {
	
	DAO dao = new DAOImpl();
	
	public ERSUser validateUser(ERSUser clientUser) {
		
		ERSUser dbUser = dao.getUserByUsername(clientUser);
		if(dbUser != null) {
			if(			dbUser.getUsername().equals(clientUser.getUsername())
					&& 	dbUser.getPassword().equals(clientUser.getPassword())		) {
				
				return dbUser;
			}
		}
		return null;
	}
	
	public int updateEmployeeInfo(ERSUser clientUser) {
		return dao.updateEmployeeInfo(clientUser);
	}
	
	public int submitRequest(Reimbursement rb) {
		return dao.createReimbursement(rb);
	}
}
