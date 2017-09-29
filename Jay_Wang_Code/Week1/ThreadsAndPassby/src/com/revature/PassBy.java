package com.revature;

import com.revature.pojo.Person;

public class PassBy {
	
	/*
	 *  Java is Pass-by value or reference?
	 *  		Value
	 *  			- more technically: java is pass-by-copy-of-reference
	 *  
	 */
	
	public static void main(String[] args) {
//		int x = 10;
//		x = passMeAnArgument(x);
//		System.out.println(x);
		Person john = new Person(1, "John");
		passMeAnObject(john);
		
		System.out.println(john);
	}
	
	public static int passMeAnArgument(int arg) {
		arg += 10;
		return arg;
	}
	
	public static Person passMeAnObject(Person person) {
		person = new Person(23, "Amy");
		person.setId(55);
		person.setName("Change the state of Person");
		return person;
	}
}
