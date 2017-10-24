package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.DAO;
import com.revature.pojo.House;

public class EmployeeService {
	@Autowired
	private DAO employeeDao;
	
	public void saveHouse() {
		System.out.println("service is calling the employee dao to save the house");
		employeeDao.saveHouse(new House());
	}
}
