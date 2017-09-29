package com.revature;


/*
 *4 Pillars of OOP
 *	-Polymorphism: something that can take many form e.g. overriding/overloading
 *	-Encapsulation: Restricting Random Access by providing a proper channel
 *	-Abstraction
 *	-Inheritance
 *		-sub class have access parent's code, for code reuse
 *		-All classes inherit from Object Class
 *		-Most common overriding method toString()
 *	Overriding -same name/same parameters: changing the implementation of a Parent's method in a child method
 *	Overloading -same name/different parameters: changing the implementation of a method in the same class
 *
 *	Implicitly - automatic, behind the scene
 *	Explicitly - must declare*/

public class Driver extends Object {
	public static void main(String[] args) {
//		System.out.println("No Hello World");
//		
//		new Duck().quack();
//		Duck d = new Duck();
//		d.hasChildren = true;
//		d.color = "white";
//		
//		//use toString() to print 
//		System.out.println(d.toString());
//		Duck anotherDuck = new Duck();
//		anotherDuck.phoneNumber = "3051231234";
//		
//		
		
		Employee bob = new Employee("bob");
		Employee alice = new Employee("alice");
		bob.setId(10);
		alice.setId(1);
		System.out.println(bob.toString());
		System.out.println(Employee.companyName);
		
	}
	// short circuit 
	// &&
	// || 
	// OCA question
	public void shortCircuit() {
		int x = 5;
		if(x == 5) {
			System.out.println("x is 5");
			
		}
	}
}
