package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.EmployeeDAO;
import com.revature.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);;
	}

	@Override
	@Transactional
	public Employee getEmployee(Integer employeeId) {
		return employeeDAO.getEmployee(employeeId);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

}
