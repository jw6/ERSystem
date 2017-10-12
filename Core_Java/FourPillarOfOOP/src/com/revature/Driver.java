package com.revature;

public class Driver {

	 String random;
	/*
	 * 
	 * 4 Pillars of Object Oriented Programming -polymorphism: something that
	 * can take many forms e.g. overriding/overloading -encapsulation:
	 * Restricting Random Access by providing a proper channel e.g.
	 * Getters/Setters with access modifiers -abstraction: -inheritance: sub
	 * class have access parent's code, for code reuse -All classes inherit from
	 * Object Class -Most common overriden method toString()
	 * 
	 * Overriding - same name/same parameters: changing the implementation of a
	 * Parent's method in a Child Class Overloading - same name/different
	 * parameters: changing the implementation of a method in the same class
	 * 
	 * Vocabulary: Implicitly - automatic, behind the scene Explicitly - must
	 * declare
	 * 
	 */
	
	public static void main(String[] args) {
		// System.out.println("hello world");
		// new Driver().shortCurcuit();
		// new Driver().duckStuff();

		
		Employee bob = new Employee("bob");
		Employee mary = new Employee("mary");
		bob.setId(10);
		mary.setId(1);
		
		System.out.println(bob);
		System.out.println(mary);
		
		System.out.println(mary.companyName); //improper
		mary.companyName = "whatever";
		
		System.out.println(Employee.companyName); //proper
		bob.companyName = "companyName has changed";
		System.out.println(Employee.companyName); //proper
		
	}

	public void duckStuff() {
		new Duck().quack();

		Duck d = new Duck();

		d.name = "Donald";
		d.hasChildren = false;
		d.color = "white";
		d.setPhoneNumber("8675309");
		System.out.println(d.name + " has children " + d.hasChildren + " " + d.color);
		System.out.println(d.toString()); // toString is implicitly called

		Duck anotherDuck = new Duck();
		anotherDuck.setPhoneNumber("3051231234");
	}

	// ShortCurcuiting - OCA Question
	// && and
	// || or
	// Both work
	public void shortCurcuit() {
		int x = 5;
		int y = 3;
		if (x == 5 || hello()) {
			System.out.println("x is 5 and y is 4");
		} else if (x == 5 && y == 3) {
			System.out.println("x is 5 and y is 3");
		} else {
			System.out.println("unsure of x and y");
		}
	}

	public boolean hello() {
		random = "hello"; //random is a instance scope variable, accessible by non-static methods
		System.out.println("hello");
		return true;
	}
	
	public static void myStaticMethod(){
//		random = "hello"; //random is a instance scope variable, NOT accessible by static methods
		System.out.println("this method is static ");
	}
}
