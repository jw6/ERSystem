package com.revature;

import com.revature.exception.BananaAgeAmountToBigException;
import com.revature.exception.InvalidBananaColorException;

public class MainClass {

	/*
	 * Error vs Exception fatal vs recoverable
	 * 
	 * Error - Fatal disrupt at runtime (non-recoverable), also could be a
	 * compilation error e.g. syntax error
	 * 		2 most common RuntimeErrors
	 * 			-OutOfMemoryError
	 * 			-StackOverflowError
	 * 
	 * Exception - Disrupt in the flow the application but is recoverable using
	 * a try/catch or throws declaration
	 * 
	 * 2 types of Exceptions 
	 * 	-checked: the compiler is looking for a try/catch
	 * or throws declaration, if not found causes compilation error 
	 * 	-unchecked:
	 * compiler doesn't care because it isn't aware or doesn't because of bad
	 * coding practice
	 * 
	 * How do we make a checked & unchecked Exception? 
	 * -Checked: create a class and inherit/extends from the Exception Class
	 * -Unchecked: create a class and inherit/extends from the RuntimeException Class
	 * 
	 * unchecked/checked by the compiler
	 * 
	 * 	BananaAgeAmountToBigException - checked: extends Exception
	 *  InvalidBananaColorException - unchecked  extends RuntimeException
	 * 
	 * 
	 */
	public static void main(String[] args) {

		Banana b = new Banana();
		try {
			// try block - write risky code, code that may throw an exception
			b.age(10);
		} catch (BananaAgeAmountToBigException e) {
			e.printStackTrace();
			// define what to do when the exception occurs
		} finally {
			/*
			 * code that will execute no matter what used to close resources
			 * like closing a file connection
			 * 
			 */
		}

//		b.setColor(color);
		b.setColor("blue");

		System.out.println(b);

	}
}
