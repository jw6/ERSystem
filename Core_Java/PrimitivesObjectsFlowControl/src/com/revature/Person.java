package com.revature;

//POJO - Plain Old Java Object
public class Person {

	//State - variables
	int id;
	String name;
	
	//No-Args Constructor is given by the Compiler when NO OTHER constructor is declared
	public Person(){}
//	public Person(){
//		System.out.println("instantiating a Person Object");
//	}
	//Overloading - Methods/Constructors Overloading - same name different parameters
	public Person(String name){
		System.out.println("instantiating a Person Object with Name: " + name);
		this.name = name;
	}
	public Person(int id, String name){
		System.out.println("instantiating a Person Object with Name: " + name);
		this.name = name;
	}
	public Person(String name, int id){
		System.out.println("instantiating a Person Object with Name: " + name);
		this.name = name;
	}
	
	//Behaviors - Methods
	public void run(){
		System.out.println("Runs");
	}
	
	
	
	
}
