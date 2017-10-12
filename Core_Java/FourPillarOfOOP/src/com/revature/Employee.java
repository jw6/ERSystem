package com.revature;

//POJO
public class Employee {

	/*
	 *  There are 4 scopes in java:
	 *  
	 *  1.	local aka block
	 *  2.	method aka parameter
	 *  3.	instance aka object aka non-static
	 *	4.  class aka static
	 *
	 * How do I reference a static member (variable/method)?
	 * 		Class Name followed by the . operator
	 */
	
	//state
	private int id; //instance scope aka object scope
	private String name;
	
	//static variable 
	//Static values can change but the memory location doesn't change!
	public static String companyName = "Revature";
	
	//NO-ARGS
	public Employee(){}
					//String name has a scope of Method aka parameter scope
	public Employee(String name) {
		super();
		this.name = name;
	}



	//Behavior
	public int getId() {
		return id;
	}
						//int id also parameter/method scope
	public void setId(int id) {
		
		if(id > 5){
			int x = 10;//local aka block scope
			System.out.println("nice id " + id + " and x = " + x);
		}
//		System.out.println(x); outside the local/block scope
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Overriden toString()
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
}
