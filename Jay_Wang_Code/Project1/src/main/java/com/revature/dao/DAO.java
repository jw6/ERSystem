package com.revature.dao;

import java.util.List;

import com.revature.bean.ERSUser;
import com.revature.bean.Reimbursement;

/**
 * 
 * @author jay
 *
 */
public interface DAO {
	/*
	 * CRUD methods only
	 */
	public void registerUser(ERSUser user);
	public int createReimbursement(Reimbursement rb);
	
	public ERSUser getUserByUsername(ERSUser user);
	public ERSUser getUserById(int ersId);
	
	public List<Reimbursement> getAllReimbursements();
	
	public ERSUser getAllReimbursementByEmployee(ERSUser user);
	public ERSUser getEmployeeByReimbursement(Reimbursement rb);
	
	public int updateEmployeeInfo(ERSUser user);
	public void updateReimbursementStatus(Reimbursement rb);
	public List<Reimbursement> getReimbursementsByEmployee(ERSUser employee);
	
	public List<ERSUser> getAllUser();
	public List<ERSUser> getAllEmployees();
	public List<ERSUser> getAllManagers();
    public int updateReimbursement(Reimbursement rb);
    
    
    
}
