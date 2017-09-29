package com.revature;

import com.revature.thread.MyMoreSpecificThread;
import com.revature.thread.MyRunnable;

public class ThreadExample {
	/*
	 *  Thread: independent state of execution 
	 *  		Threads don't rely on each other
	 *  
	 *  		2 threads at start
	 *  			-main method: user define thread - shortly lived
	 *  			-garbage collection: daemon thread - continuous
	 *  
	 *  Multithreading - multiple threads running concurrently 
	 *  
	 *  How do we create threads in Java?
	 *  		implements Runnable
	 *  		extends Thread
	 *  
	 *  Which is better, extends Thread or implements Runnable?
	 *  		-if we use extends Thread, we take up our only and only extends 
	 *  		-When extends a class, you're changing the behavior of it, when overriding the run()
	 *  		you're not changing the way thread interact
	 *  			better to use the run() found in the Runnable Interface
	 *  
	 *  Developer don't have control over the order of thread execution
	 *  Developer can't force one thread to run on other thread
	 *  		What we can do:
	 *  			setPriority(); 1-10, 1-low, 10-high, 5-normal/default
	 *  
	 */

	
	
	public static void main(String[] args) {
		Thread t = new MyMoreSpecificThread();
//		t.run(); we are running the logic of the run() on the same thread
		t.setPriority(10);
		t.start(); // Call start() to spin up a new thread and then that thread will call run();
		
		Runnable target = new MyRunnable();
		Thread t1 = new Thread(target);
		t1.start();
		
		int i = 0;
		while(i < 10) {
			System.out.println(Thread.currentThread().getName());
			i++;
		}
			
	}
}
