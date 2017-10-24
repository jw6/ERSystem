package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.DAO;
import com.revature.pojo.House;

public class ManagerService {
	@Autowired
	private DAO managerDao;
	
	public void saveHouse() {
		System.out.println("service is calling the manager dao to save the house");
		managerDao.saveHouse(new House());
	}
}
