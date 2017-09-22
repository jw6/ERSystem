package com.revature;

import com.revature.pojo.Person;

public class PassBy {

	/*
	 * 	Java is Pass-by value or reference?
	 * 		Java is Pass-By-Value
	 * 			-more technically: java is pass-by-copy-of-reference
	 * 		
	 */
	public static void main(String[] args) {
//		int x = 10;
//		x = passMeAnPrimitive(x);
//		System.out.println(x);
		
		Person john = new Person(1, "John");
		int[] x = new int[5];
		Object y = (Object) x;
		passMeAnObject(john);
		
		System.out.println(john);
		
		
	}
	
	public static int passMeAnPrimitive(int arg){
		arg += 10;
		return arg;
	}

	public static Person passMeAnObject(Person person){
		person = new Person(23, "amy");
		person.setId(55);
		
		System.out.println("Changing the state of person: " + person.getId());
		return person;
	}
}
