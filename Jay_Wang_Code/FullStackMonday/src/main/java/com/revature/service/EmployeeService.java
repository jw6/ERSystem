package com.revature.service;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public void deleteEmployee(Integer employeeId);
	
	public Employee getEmployee(Integer employeeId);
	
	public Employee updateEmployee(Employee employee);
}
