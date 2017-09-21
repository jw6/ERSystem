package com.revature;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("hello world");
		System.out.println("ctrl + space!");
		
		new MainClass().primitives();
		
		MainClass mc = new MainClass();
		mc.primitives();

		// 2 objects of type person
		// 3 objects references
		// p1 & p3 objects reference to the first instantiated Person object
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = p1;
		
		// 1D 
		
		int[] myArrays = new int[5];
		int[] myArrays1 = {2, 3, 4, 5};
		
		System.out.println(myArrays1[0]);
		System.out.println(myArrays1[2]);
		//java.lang.ArrayIndexOutOfBoundsException: 4
		//Unchecked
//		System.out.println(myArrays1[4]);
		// 2D
		
		int[][] my2dArray = new int[2][3];
		int[][] my2dArray1 = {{2, 3}, {3, 4}};
		int[][] my2dArray2 = new int[2][];
		int[][] my2dArray3 = new int[][] {{7, 2}, {24, 9}};
		int my2dArray4[][] = new int[][]{{7, 2}, {24, 9}};
		
		for(int i = 0; i < my2dArray1.length; i++) {
			for(int j = 0; j < my2dArray1[i].length; j++) {
				System.out.println(my2dArray1[i][j]);
			}
		}
	}
		
	public void primitives() {
		byte b = 2;		// 8 bit
		short s = 5;		// 16 bit
		int n = 3;		// 32 bit
		long l = 20;		// 64 bit
		
		float f = 10;	// 32 bit
		double d = 0.25;	// 64 bit
		
		boolean bl = true; // N/A differs between machines
		char c = 'a';	// 16 bits
		char ch = 5;		//OCA question, this will compile
		
		System.out.println("ch " + c);
		
		//Not a primitive data type but an Object
		//Note the capital S
		String str = "my string";
	}
}
