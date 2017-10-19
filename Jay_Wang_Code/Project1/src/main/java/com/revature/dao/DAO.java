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
	
	public List<ERSUser> getAllEmployees();
	public List<Reimbursement> getAllReimbursement();
	
	public ERSUser getAllReimbursementByEmployee(ERSUser user);
	public ERSUser getEmployeeByReimbursement(Reimbursement rb);
	
	public int updateEmployeeInfo(ERSUser user);
	public void updateReimbursementStatus(Reimbursement rb);
	
}
