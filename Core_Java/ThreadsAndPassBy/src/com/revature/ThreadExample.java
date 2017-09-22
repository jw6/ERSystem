package com.revature;

import com.revature.thread.MyMoreSpecificThread;
import com.revature.thread.MyRunnable;

public class ThreadExample {
	/*
	 * Thread - independent state of execution
	 * 		Threads don't rely on each other
	 *  	
	 *  	2 threads at start:
	 *  		-main method: user defined thread - shortly lived
	 *  		-garbage collection: daemon thread - continuous
	 *  
	 *  Multithreading - multiple threads running concurrently
	 *  
	 *  How do we create Threads in Java?
	 *  	-extend the thread
	 *  	-implements Runnable
	 *  
	 *  Which is better extends Thread or implements Runnable?
	 *  	-if we use extends Thread, we take up our only and only extends
	 *  	-When extends a class, you're change the behavior of it, when overriding the run() you're not changing the way Threads interact
	 *  		better to use the run() found in the Runnable Interface
	 *  
	 *  Developers don't have control over the order of thread execution. Can't force one thread to run over another Thread.
	 *  	What we can do:
	 *  		setPriority(); 1-10, 1-low 10-high, 5-normal/default 
	 */
	public static void main(String[] args) {
		
		Thread t0 = new MyMoreSpecificThread();
//		t.run(); we are running the logic of the run() on the same thread
		t0.setPriority(10);
		t0.start(); //Call start() to spin up a new thread and then that thread will call run();
		
		Runnable target = new MyRunnable();
		Thread t1 = new Thread(target);
		t1.start();
		
		int i = 0;
		while(i < 10){
			System.out.println(Thread.currentThread().getName());
			i++;
		}
		
	}
}
