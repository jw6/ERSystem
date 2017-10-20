package com.revature.service;

import java.util.List;

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
	
	public List<Reimbursement> getAllReimbursements(){
		return dao.getAllReimbursements();
	}
	
	public List<Reimbursement> getReimbursementsByEmployee(ERSUser employee){
		return dao.getReimbursementsByEmployee(employee);
	}
	
	public List<ERSUser> getAllManagers() {
		return dao.getAllManagers();
	}
	
}
