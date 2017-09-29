package com.revature;

public class Employee {
	
	/*
	 * There are 4 scopes in java:
	 * 		local aka block
	 * 		method aka parameter
	 * 		instance aka object non static
	 * 		class aka static
	 * 
	 * How do I reference a static member (variable/method)?
	 * 	Class name follower by a dot operator
	 */	
	//state
	private int id; 			//instance scope aka object scope
	private String name;
	
	//static variable
	//static values can change but the memory location doesn't change!
	public static String companyName = "revature";
	public Employee() {
			//String name has a scope of Method aka parameter scope
	}
	
	public Employee(String name) {
		super();
		this.name = name;
	}
	
	//Behaviors
	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	private int getId() {
		return id;
	}

	void setId(int id) {
		if(id > 5) {
		
		}
		
		this.id = id;
	}
}
