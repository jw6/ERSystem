package com.revature;

//POJO - Plain Old Java Object
public class Duck extends Object {

	// state - variables
	// Our state access modifier is none so it is default
	String name;
	String color;
	boolean hasChildren;

	// Private Access Modifier - Only been seen in THIS class
	private String phoneNumber;

	// NO-ARGS
	public Duck() {
	}

	// Behavior - method
	public void quack() {
		System.out.println("quack");
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	//Encapsulation
	public void setPhoneNumber(String phoneNumber) {
		/*
		 * provide restrictions before actually setting the phoneNumber variable
		 * example
		 * 	-check the length of phoneNumber
		 * 	-remove unneed characters like _, -, spaces
		 *  -etc
		 */
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Duck [name=" + name + ", color=" + color + ", hasChildren=" + hasChildren + "]";
	}

}
