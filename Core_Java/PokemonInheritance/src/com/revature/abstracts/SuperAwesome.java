package com.revature.abstracts;

public abstract interface SuperAwesome extends Flyable, Swimable{

	/*
	 *  state implicitly public static final
	 *  		reference by class name and the dot operator .
	 *  
	 *   SuperAwesome.x
	 *   	
	 */
		   				int x = 10;
		   		 public int y = 11;
		  public static int z = 12;
	public static final int a = 13;
}
