package com.revature.abstracts;

public interface Swimable {

	public default void swim(){
		System.out.println("all pokemon clearly swim the same way");
	}
	
//	public double test();
}
