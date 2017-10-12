package com.revature;

public class CalculatorImpl implements Calculator{

	@Override
	public int add(int x, int y) {
		return x+y;
	}

	@Override
	public int subtract(int x, int y) {
		return x-y;
	}

	@Override
	public int multiply(int x, int y) {
		if(false){
			
		}
		
		while(true){
		}
		
		
		
	}

	@Override
	public int divide(int x, int y) throws IllegalArgumentException {
		if(y == 0){
			throw new IllegalArgumentException("Don't give me a 0 for the 2nd argument");
		}
		return x/y;
	}

	
	
}
