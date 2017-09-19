package com.revature;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("hello world");
		System.out.println("ctrl + space!");
		System.out.println("ctrl + d = delete line");
		System.out.println("ctrl + / = comment/uncomment");
		System.out.println("ctrl + shift + f = format code");

		new MainClass().primitives(); // Method chaining

		MainClass mc = new MainClass(); // Not Method chaining
		mc.primitives();

//		objects(); //static method, doesn't need an instantiation of the class
//		arrays();

		//What is Flow Control? - loops, if/else, switch
		int[] myArray = { 2, 3, 4, 5 };
		int x = 0;
//		for(int i = 0; i < myArray.length; System.out.println(hello())){
//			System.out.println(++x);
////			System.out.println("var value: " + myArray[i]);
//			 i++;
//		}
//		
//		System.out.println( 6 + 5  + hello() + (6 + 6) + 5); //order of operation
		
		//2d loop
		int[][] my2dArray = { { 2, 3 }, { 3, 4 } };
		for(int i = 0; i < my2dArray.length; i++){
			for(int j = 0; j < my2dArray[i].length; j++){
				System.out.print(my2dArray[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static String hello(){
		return "Hello";
	}

	public void primitives() {

		// Primitives - datatypes, not objects
		// 8 primitive datatypes
		byte b = 2; // 8 bit
		short s = 5; // 16 bit
		int n = 3; // 32 bit
		long l = 20;// 64 bit

		float fo = 10.25F; // OCA Question f or F
		float f = 10; // 32 bit
		double d = 0.25D; // 64 bit

		boolean bl = true; // N/A differs between machines
		char c = 'a'; // 16 bit
		char ch = 55; // OCA Question, this will compile

		// System.out.println("ch " + ch);

		// Not a primitive datatype but an Object
		// Note the Capital S
		String str = "my string";
	}

	public static void objects() {
		// 2 Objects of type Person
		// 3 Object References
		// p1 & p3 object reference to the first instantiated Person Object
		Person p1 = new Person();
		Person p2 = new Person("P2", 55);

		new Person(55, "P2");
		new Person("P2");
		// new Person(55); //no constructor with int as argument
		Person p3 = p1;
	}

	public static void arrays() {
		// Arrays - Group of related datatypes, Data Structure, Continuous Block
		// of Memory, fixed sized, indexed 0
		// 1D
		int[] myArray = new int[5];
		int[] myArray2 = { 2, 3, 4, 5 };

		System.out.println(myArray2[0]); // 2
		System.out.println(myArray2[2]); // 4
		// System.out.println(myArray2[4]); //java.lang.ArrayIndexOutOfBoundsException -Example of Unchecked
		// Exception: Bad Coding practices
		// System.out.println("after exception"); won't execute if
		// ArrayIndexOutOfBoundsException is thrown
		// 2D
		int[][] my2dArray = new int[2][3];
		int[][] my2dArray1 = { { 2, 3 }, { 3, 4 } };
		int[][] my2dArray2 = new int[2][]; // OCA Questions
		int[][] my2dArray3 = new int[][] { { 6, 7 }, { 8, 10 } };
		int my2dArray4[][] = new int[][] { { 6, 7 }, { 8, 10 } };
		int[] my2dArray5[] = new int[][] { { 6, 7 }, { 8, 10 } };

		// myArray.length;//provides the size of the array
		// 3d
		int[][][] intArr3D = new int[1][1][1]; // and so on 4d...
	}
}
