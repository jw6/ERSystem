package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDAO {
	/*
	 * CRUD methods
	 */
	public void addEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public void 	deleteEmployee(Integer employeeId);
	
	public Employee updateEmployee(Employee employee);
	
	public Employee getEmployee(int employeeId);
}
