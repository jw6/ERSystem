package com.revature.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Employee;

public class empDaoImpl implements empDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public void update(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

}
