package com.revature;
//POJO - Plain Old Java Object
public class Duck {
	//State - variables
	String name;
	String color;
	boolean hasChildren;
	
	//Private Access Modifier - Only been seen in THIS class
	private String phoneNumber;
	
	//NO-ARGS
	public Duck() {
		
	}
	
	//Behaviour
	public void quack() {
		System.out.println("Quack");
	}

	private String getPhoneNumber() {
		return phoneNumber;
	}
	/*
	 * Encapsulation
	 */
	private void setPhoneNumber(String phoneNumber) {
		/*
		 * provide restriction before actually setting the phoneNumber variable
		 * 	-check the length of phoneNUmber
		 * 	-remove unneed characters like _, -, spaces
		 * 	-etc
		 */
		this.phoneNumber = phoneNumber;
	}
}
