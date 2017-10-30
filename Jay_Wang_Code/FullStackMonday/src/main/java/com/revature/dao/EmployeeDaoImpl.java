package com.revature.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession()
													.load(Employee.class, employeeId);
		if(employee != null) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		return (Employee) sessionFactory.getCurrentSession()
										.get(Employee.class, employeeId);
	}

}
