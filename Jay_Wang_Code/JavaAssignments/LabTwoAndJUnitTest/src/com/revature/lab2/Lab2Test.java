package com.revature.lab2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Lab2Test {
	@BeforeClass
	public static void beforeClass() {
		System.err.println("***** Before test class *****\n");
	}
	
	@Before
	public void before() {
		System.err.println("*** Before method testing ***");
	}
	
	@Test
	public void testFibonacci() {
		System.err.println("Testing fibonacci method");
		assertEquals(0, Lab2.fibonacci(0));
		assertEquals(1, Lab2.fibonacci(1));
		assertEquals(1, Lab2.fibonacci(2));
		assertEquals(55, Lab2.fibonacci(10));
	}
	
	@Test
	public void testSort() {
		System.err.println("Testing sort method");
		int[] array = {6, 4, 5, 3, 2, 1};
		int[] expected = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(expected, Lab2.sort(array) );
	}
	
	@Test
	public void testFactorial() {
		System.err.println("Testing factorial method");
		assertEquals(6, Lab2.factorial(3));
		assertEquals(24,Lab2.factorial(4));
	}
	
	@Test
	public void testRotateLeft() {
		System.err.println("Test rotateLeft method");
		int[] array = {1, 2, 3, 4, 5};
		int[] expected1 = {2, 3, 4, 5, 1};
		assertArrayEquals("Rotate left 1 number ", expected1, Lab2.rotateLeft(array, 1));
		int[] array1 = {1, 2, 3, 4, 5};
		int[] expected2 = {3, 4, 5, 1, 2};
		assertArrayEquals("Rotate left 2 number ", expected2, Lab2.rotateLeft(array1, 2));
	}
	
	@Test
	public void testBalancedBrackets() {
		System.err.println("Test balancedBracket method");
		assertEquals(true, Lab2.balancedBrackets("()"));
		assertEquals(false, Lab2.balancedBrackets("(]"));
		assertEquals(true, Lab2.balancedBrackets("{([])}"));
		assertEquals(true, Lab2.balancedBrackets("{([abcd])}"));
		assertEquals(false, Lab2.balancedBrackets("{([abcd)}"));

	}
	
	@After
	public void after() {
		System.err.println("*** Method has been tested *** \n");
	}
	
	@AfterClass
	public static void afterClass() {
		System.err.println("***** All methods have been tested *****");
	}
}
