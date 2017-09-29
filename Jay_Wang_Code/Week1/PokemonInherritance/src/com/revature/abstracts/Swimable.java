package com.revature.abstracts;

public interface Swimable {
	public default void swim() {
		System.out.println("all pokemons swim the same way");
	}
	
	public void talk();
}
