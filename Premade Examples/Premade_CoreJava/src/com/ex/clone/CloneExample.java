package com.ex.clone;

public class CloneExample {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		CloneClass one = new CloneClass();
		one.setSomeInt(5);
		
		CloneClass oneReferenced = one;
		if(oneReferenced == one){
			System.out.println("oneReferenced == one");
		}else {
			System.out.println("oneReferenced != one");
		}
		
		Object oneCloned = one.clone();
		if(oneCloned == one){
			System.out.println("oneCloned == one");
		}else {
			System.out.println("oneCloned != one");
		}
		
		System.out.println(one.getSomeInt());
		System.out.println(oneReferenced.getSomeInt());
		System.out.println(((CloneClass)oneCloned).getSomeInt());
	}
}
