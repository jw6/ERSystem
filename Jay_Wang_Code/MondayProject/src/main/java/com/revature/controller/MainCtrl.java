package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.empDaoImpl;
import com.revature.model.Employee;

public class MainCtrl {
	
	@Autowired
	private empDaoImpl service;
	
	@RequestMapping(value= {"/save", "/update"},method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> helper(@RequestBody Employee emp) {
		System.out.println("save employee information" + emp);
		
		service.update(emp);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> handleException(Exception e) {
		System.out.println("exception here");
		return new ResponseEntity<Exception>(e, HttpStatus.CONFLICT);
	}
}
