package com.revature.lab1;

/**
 * @author Jay Wang
 * Sep 23, 2017
 */

import static org.junit.Assert.*;
import org.junit.*;

public class Lab1Test {
	@BeforeClass
	public static void beforeClass() {
		System.err.println("***** Before test class *****");
	}
	
	@Before
	public void before() {
		System.err.println("*** Before method testing ***");
	}
	
	@Test
	public void testCastToInt() {
		System.err.println("Testing CastToInt ");
		Lab1 tester = new Lab1();
		assertEquals("Testing CastToInt ", 2, tester.castToInt(2.2));
		assertEquals("Testing CastToInt ", 3, tester.castToInt(3.2));
	}
	
	@Test
	public void testCastToByte() {
		System.err.println("Testing CastToByte ");
		Lab1 tester = new Lab1();
		assertEquals((byte) 2, tester.castToByte((short)2));
		assertEquals((byte) 4, tester.castToByte((short)4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDivideShouldThrowException() {
		Lab1 tester = new Lab1();
		System.err.println("This should throw an exception and pass test");
		tester.divide(6.0, 0.0);
	}
	
	@Test
	public void testDivide() {
		Lab1 tester = new Lab1();
		System.err.println("Divide should pass test");
		assertEquals(2.5, Lab1.divide(7.5, 3.0), 0);
	}
	
	@Test 
	public void testEven() {
		Lab1 tester = new Lab1();
		System.err.println("");
		assertEquals("10 is an even number",true, tester.isEven(10));
		assertEquals("11 is not an even number", false, tester.isEven(11));
	}
	
	@Test
	public void testIsAllEven() {
		System.err.println("Test isAllEven method");
		Lab1 tester = new Lab1();
		int[] array = {2, 4 ,6, 8};
		assertEquals(true, tester.isAllEven(array));
		array[0] = 1;
		array[1] = 3;
		assertEquals(false, tester.isAllEven(array));
	}

	@Test
	public void testAvarage() {
		System.err.println("Test average method");
		int[] array = {2, 4 ,6, 8};
		Assert.assertEquals(5, Lab1.average(array), 0);
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
