package com.revature;

//import static - grabs all the static methods or a single
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail; fail() now must be Assert.fail() instead of fail();
//static import  org.junit.Assert.fail; not legal - OCA Question

//import grabs the class
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


/*
 * Add junit/hamcrest jars by:
 * 		1. copying the folder they are located in, paste into project
 * 		2. right-click on project
 * 		3. properties
 * 		4. java build path
 * 		5. Libraries
 * 		6. add jar, NOT external
 * 
 * Code Coverage: how much code is coverd by unit tests
 * 
 * @Test - a single test
 * 		Tests should not conflict with one another
 * 		Each Test is independent, one test should not cause another test to fail
 * 		Tests do not run in any order
 * 
 * Junit annotation @:
 * 		@Test
 * 		@BeforeClass
 * 		@Before
 * 		@AfterClass
 * 		@After
 * 		@Ignore
 * 
 */
public class CalculatorTest {

	@BeforeClass
	public static void beforeClass(){
		System.out.println("****Before all methods****");
	}
	
	@Before
	public void beforeEachMethod(){
		System.out.println("*Called before each method - setup requirements*");
	}
	
	//all junit test have the method "public void"
	@SuppressWarnings("deprecation")
	@Test //this tells us run this method as a Junit Test
	public void testAddShouldReturnSum(){
		System.out.println("testing - testAddShouldReturnSum");
		Calculator cal = new CalculatorImpl();
		Assert.assertEquals("10 + 5 = 15", 15, cal.add(10, 5));
		Assert.assertEquals("10 + 0 = 10", 10, cal.add(10, 0));
		Assert.assertEquals("0 + 10 = 10", 10, cal.add(0, 10));
	}
	
	@Ignore
	@Test
	public void testSubtract() {
		System.out.println("testing - testSubtract");
		Assert.fail();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDivideZeroForYshouldFail(){
		Calculator cal = new CalculatorImpl();
		cal.divide(6, 0);
		
	}
	
	@Test(timeout=3000)
	public void testMultiple(){
		
		new CalculatorImpl().multiply(10, 5);
		assertEquals(50, 50);
	}
	
	@After
	public void afterEachMethod(){
		System.out.println("**finished method, clean up resources**");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("****after all method have finished****");
	}

}
