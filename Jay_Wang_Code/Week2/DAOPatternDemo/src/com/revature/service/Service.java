package com.revature.service;

import com.revature.dao.DAO;
import com.revature.dao.DAOImpl;
import com.revature.pojo.Customer;

public class Service {
	DAO dao = new DAOImpl();
	
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
	}
}
