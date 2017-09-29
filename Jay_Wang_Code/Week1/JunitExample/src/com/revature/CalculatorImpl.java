package com.revature;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int x, int y) {
		return (x + y);
	}

	@Override
	public int subtract(int x, int y ) {
		return x - y;
	}

	@Override
	public void multiply(int x , int y) {
		while(true) {
			
			
		}
	}

	@Override
	public int divide(int x, int y) throws IllegalArgumentException {
		if(y == 0) {
			throw new IllegalArgumentException();
		}
		return x / y;
	}

}
