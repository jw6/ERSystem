package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;

public class Driver {
	public static void main(String[] args) {
		System.out.println("hello spring, where do we start it?");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		EmployeeService eapp = (EmployeeService) ac.getBean("employeeService");
		
		ManagerService mapp = (ManagerService) ac.getBean("managerService");
		
		eapp.saveHouse();
		mapp.saveHouse();

		System.out.println("end of app");
	}
}
