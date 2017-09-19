package com.revature;

public class Person {
	
	//state variables
	int id;
	String name;
	
	//No args constructor
	public Person() {
		System.out.println("Instantiated a Person Object");
	}
	
	//Overloaded constructor/method, same name but different argument
	public Person(String name) {
		this.name = name;
		System.out.println("Instantiated a Person Object");
	}
	
	
}
