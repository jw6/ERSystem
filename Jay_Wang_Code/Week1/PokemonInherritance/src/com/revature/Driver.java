package com.revature;

import com.revature.abstracts.Flyable;
import com.revature.pojo.Pikachu;
import com.revature.pojo.Pokemon;

public class Driver {
	public static void main(String[] args) {
		/*
		 * 
		 * is a rule: is the classs apart of the inheritance chain
		 * 
		 * Abstract class - template for other classes to inherit
		 * 	Characteristics of an Abstract class
		 * 		-Cannot instantiate an Abstract Class
		 * 		-Can have concrete methods
		 * 		-Can have abstract methods
		 * 
		 * Interfaces: - is a contract 
		 * 		Characteristics of an Interface
		 * 			-Cannot instantiate an Interface
		 * 			-Methods are abstract by default
		 * 			-classes implements interfaces
		 * 			-Methods can be concrete when using the default keyword, added in java 1.8
		 * 			-state is implicitly/required: public static final
		 * Method with {} defined, implemented, concrete, body
		 * Method without {} -abstract
		 * 
		 * Cannot have a Concrete Class with abstract method(s)
		 * 
		 * super(); implicitly the first line of every constructor
		 * this(); to constructor chain
		 * 
		 * 4 Access Modifiers:
		 * 			Most restrict to less restrict
		 * 		private - only this class can access
		 * 		default(no modifier) - only this package
		 * 		protected - only this package & subclasses
		 * 		public - anywhere
		 * 
		 * Final Keyword - Used 3 ways:
		 * 		final variable: once initialized can't be changed; only use = once
		 * 		final method: can't override but still inherited
		 * 		final class: class be subclassed, example String Class is final, wrapper classes
		 * 
		 * What is the difference between final, finally, finalized? Very common
		 *		final keyword
		 *		finally - try/catch 
		 * 		finalize method called by garbage collector shotly before collection 
		 * 
		 * Wrapper Classes: corresponding classes of primitive datatypes 
		 * 		int - Integer
		 * 		double - Double	
		 * 		boolean - Boolean
		 * 
		 * treat primitives data types as Objects 
		 *
		 * Boxing/unboxing and Autoboxing
		 * 		Autoboxing - introduce in Java 1.5
		 * 		Boxing - converting primitives into the Object
		 * 		Unboxing - object back to its primitive type
		 * 		Autoboxing -converting automatically
		 * 
		 * keyword vs Reserved Word
		 * 		Keywords - Java is suing like final
		 * 		Reserved - potentially used in the future but not currently const
		 * 
		 * Casting:
		 * 		upcasting:		up the inheritance tree, implicit always possible
		 * 		downcasting:		down the inheritance tree, must explicitly write, can cause ClassCastException
		 * 		
		 */
		int x = 5;
		Integer y = 5;				//autoboxing: happens implicitly
		Integer i = new Integer(5);	//boxing, explicitly
		float f = 10.25f;
		
		//right side must pass the is-a rule
		Pikachu p = new Pikachu();
		p.isShiny();
		
		Pokemon pl = new Pikachu(); // downcasting 
		((Pikachu) pl).isShiny();
		
		Flyable fly = new Pikachu();
		((Pikachu) fly).isShiny(); // casting the object reference temporary to Pikachu
		new Pikachu();
		
		Pikachu jq = (Pikachu) fly;
	}
}
