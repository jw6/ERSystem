package com.revature;

import com.revature.abstracts.Flyable;
import com.revature.abstracts.SuperAwesome;
import com.revature.pojo.Pikachu;
import com.revature.pojo.Pokemon;

public class Driver {

	/*
	 * is-a rule: is the class apart of the inheritance chain
	 * 
	 * 
	 * Abstract Class - template for other classes to inherit
	 * 		Characteristics of an Abstract Class
	 * 			-Cannot instantiate an Abstract Class
	 * 			-can have concrete methods
	 * 			-can have abstract methods
	 * 			-classes extends classes
	 * 			-only extends one class
	 * 
	 * Interfaces: is a contract
	 * 		Characteristics of an Interface
	 * 			-Cannot instantiate an Interface
	 * 			-Methods are abstract by default
	 * 			-classes implements interfaces, & can implements many
	 * 			-Methods can be concrete when using the default keyword, added in java 1.8
	 * 			-state is implicitly/required: public static final
	 * 
	 * Method with {} - defined, implemented, concrete, body
	 * Method without {} - abstract
	 * 
	 * Cannot have a Concrete Class with abstract method(s)
	 * 
	 * Super(); implicitly the first line of every constructor
	 * this(); to constructor chain
	 * 
	 *  4 Access Modifiers:
	 *  	 	Most Strict to Less Strict
	 *  	private - only this class can access 
	 *  	default (no modifier) - only this package
	 *  	protected - only this package & subclasses
	 *  	public - anywhere
	 *  
	 *  Final Keyword - Used 3 ways:
	 *  	final variable: once initialized can't be changed, only use = once
	 *  	final method: can't override but still inherited 
	 *  	final class: can't be subclassed, example String Class is final, wrapper classes
	 *  
	 *  What is the difference between final, finally, finalized? very common interview question
	 *  	final keyword
	 *  	finally - try/catch block
	 *  	finalize method called by the garbage collector shortly before collection
	 *  
	 *  
	 *  Wrapper Classes: corresponding classes of primitive datatypes
	 *  	int - Integer
	 *  	double - Double
	 *  	boolean - Boolean
	 *  treat primitive datatype as Objects
	 *  
	 *  Boxing/unboxing and Autoboxing
	 *  	introduce in 1.5
	 *  	Boxing - converting primitives into the Object
	 *  	Unboxing - object back to its Primiting
	 *  	Autoboxing - converting automatically
	 *  
	 * 
	 *  Keyword vs Reserved Word
	 *  	Keywords - java is using like final
	 *  	Reserved - potentially used in the future but not currently const
	 * 
	 * Casting: 
	 * 		upcasting: up the inheritance tree, implicit always possible
	 * 		downcasting: down the inheritance tree, must explicitly write, can cause ClassCastException
	 * 
	 */
	
	public static void main(String[] args) {
//		new Pokemon(); //cannot instantiate an abstract class
		new Pikachu().getPokemonId();
		
		int x = 5;
		Integer y = 5; //autoboxing: happens implicitly 
		Integer i = new Integer(5); //boxing, explicitly
		float f = 10.25f;
		
//		new Flyable();  //cannot instantiate an interface
			
					//right side must pass the is-a rule
		Pikachu p = new Pikachu();
		p.isShiny();
		
		Pokemon poke = new Pikachu();
		poke.getPokemonId();
		
		Flyable fly = new Pikachu();
		fly.flyFaster();
		((Pikachu) fly).isShiny();//casting the object reference temporary to Pikachu
		
		Pikachu castedFly =  (Pikachu) fly;
		castedFly.isShiny();
		
//		castedFly.test();
		
		System.out.println(SuperAwesome.x);
	}

}
