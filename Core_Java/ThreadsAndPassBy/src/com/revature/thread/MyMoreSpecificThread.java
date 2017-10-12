package com.revature.thread;

public class MyMoreSpecificThread extends Thread{

	
	@Override
	public void run() {
		//Provide a separate thread's logic to execute
			//another thread's main method
		for(int i =0; i <= 10; i++){
			System.out.println("\t"+Thread.currentThread().getName());
		}
	}
	
}
