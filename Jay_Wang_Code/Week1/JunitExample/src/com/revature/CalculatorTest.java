package com.revature;

//import static - grabs all the static methods or a single
import static org.junit.Assert.*;
//import static org.junit.Assert.fail; fail() becomes Assert.fail() if static is removed
//static import org.junit.Assert.fail; not legal - OCA Qeustion

//import - grabs the class
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

/*
 * Add JUnit/hamcrest jars by:
 * 		1. copying the folder they are located in, pasts into project
 * 		2. right-click on project
 * 		3. properties
 * 		4. java build path
 * 		5. Libraries
 * 		6. add jar, NOT external 
 * 
 * Code Coverage: how much code is covered by unit tests
 * 
 * @Test - a single test
 * 		Tests should not conflict with one another
 * 		Each Test is independent, one test should not cause another test to fail
 *		Tests do not run in any order 
 *
 *Junit annotation @:
 *		@Test
 *		@Test()
 *		@BeforeClass (must be static)
 *		@Before
 *		@After 
 *		@AfterClass (must be static)
 *		@ignore
 */



public class CalculatorTest {
	@BeforeClass
	public static void beforeClass(){
		System.err.println("Before class *****");
	}
	
	
	@Before
	public void beforeEachMethod() {
		System.err.println("Called before each method - set method");
	}
	
	//all JUnit test have the method "public void"
	@SuppressWarnings("deprecation")
	@Test //this tells us run this method as a JUnit Test
	public void testAddShouldReturnSum() {
		System.err.println("testing - testAddSHouldReturnSum");
		Calculator cal = new CalculatorImpl();
		Assert.assertEquals("10 +5", 15, cal.add(10, 5));
		Assert.assertEquals("10 +5", 10, cal.add(0, 10));
		Assert.assertEquals("10 +5", 10, cal.add(10, 0));
	}
	
	@Ignore
	@Test
	public void testSubtract() {
		System.out.println("Print for testing ***");
		fail();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDivideZeroForYshouldFail() {
		Calculator cal = new CalculatorImpl();
		cal.divide(6, 0);
	}
	
	@Test(timeout = 5000)
	public void testMultiply() {
		new CalculatorImpl().multiply(2, 5);
		assertEquals(10, 10);
	}
	
	@After
	public void afterEachMethod() {
		System.out.println("finsihed method, clean up resources");
	}
	
	@AfterClass
	public static void afterClass() {
		System.err.println("After class ******");
	}
	
}
