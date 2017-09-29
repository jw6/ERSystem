package com.revature;

import com.revature.exception.InvalidBananaColorException;

public class MainClass {
	/*
	 * Error vs Exception
	 * 	fatal vs recoverable
	 * 
	 * Error - Fatal disrupt at runtime (non-recoverable), also could be compilation error e.g. syntax error
	 * 		compilation error e.g. syntax error
	 * 			-OutOfMemoryError
	 * 			-StackOverflowError
	 * 
	 * Exception -  Disrupt in the flow the application but is recoverable using a try/catch or throws declaration
	 * 
	 *	2 types of Exceptions:
	 *		-checked: the compiler is looking for a try/catch or throws declaration, if not found causes compilation error
	 *		-unchecked: compiler doesn't care because it isn't aware or doesn't because of bad coding practice
	 *
	 *How do we make a checked & unchecked Exception?
	 *		-checked: create a class and inherit/extends from the Exception 
	 *		-unchecked: create a class and inherit/extends from the RuntimeException Class
	 *	unchecked/checked by the compiler
	 *
	 *	BananaAgeAmountToBigException - checked: extends Exception
	 *	InvalidBananaColorException - unchecked: extends RuntimeException
	 */
	
	
	public static void main(String[] args) {	
//		String test = null;
//		test.length();	
		
		Banana b = new Banana();
		
		try {
			b.setColor("red");
		} catch (InvalidBananaColorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//try block requires either catch or finaly or both
		
		try {
			//Try block - write risky code, code that may throw an exception
			b.age(10);
		} catch (BananaAgeAmountToBigException e ) {
			//define what to do when the exception occurs
			e.printStackTrace();
		} finally {
			/*
			 * code that will execute no matter what 
			 *	used to close resources like closing a file connection
			 *
			 */
		}
		System.out.println(b);
	}

}
