package com.revature;
import java.util.Map;

import com.revature.*;
import com.revature.pojo.BatMan;
import com.revature.pojo.BruceWayne;
import com.revature.pojo.PeterPark;
import com.revature.pojo.SpiderMan;
import com.revature.abstracts.SuperHero;

public class Main {
	public static void main(String[] args) {
		//
		// 	Make a main class that shows you used all the above
		//	Test the senarios below (not graded)
		//1. Instantiate an class with an AbstractClass Reference, 
		//    use control space to see what variables, and methods are available
		//2. Cast that AbstractClass reference down. Which method is called the parent or child?
		// Answer: Since it's cast down, child is called	
		//3. Can you remove the exceptions in the subClasses? 
		//    or change it from RuntimeException to Exception or vice versa
		//    Can you change it to a different Exception?
		// Answer: I guess not. it's more restrict in overriden method of subclass
		// I don't think it's appropriate to access parent class's method either 
		// remove or change exception
		
		//4. Catch the Exceptions, add a finally block, call a method from the catch block
		//    Does the method run before or after the finally block?
		// Answer: in a try/catch/finally block, catch runs first before finally
		
		//5. What are the default values of each scope?
		//    Objects = null for instances at Static aka Class scope
		//    Objects = ? for Instance, Parameter, and Local scope?
		//		for local variables is none
		//		for instance, like int, short, byte is zero, boolean is false and obj references are null
		//		for parameter, not quite sure, I think it's same as instance.
		//    Each primitive dafault value? byte/short/int = 0, char = '\u0000' boolean = false
		//		float = 0.0f, double = 0.0d, long = 0L
		//
		SuperHero peter = new SpiderMan();
		System.out.println();
		((SpiderMan) peter).crawling();
		System.out.println();
		((SpiderMan) peter).naturalSuperPower(true);
		System.out.println();
		PeterPark littlePeter = new PeterPark();
		System.out.println();
		SuperHero bWayne = new BatMan();
		System.out.println();
//		peterPark.equiments();
//		peterPark.beingSuperHero();
		
		SuperHero bruce = new BatMan("Joker");
		System.out.println();
//		((BatMan) bruce).beingBatMan();
		((BatMan) bruce).equiment();
		BruceWayne wayne = new BruceWayne();
	}
}
