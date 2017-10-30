package com.revature.service;

import org.springframework.stereotype.Component;

@Component("appService")
public class AppService {
	
	public AppService() {
		System.out.println("Calling from constructor");
	}
	public void playComedyShow() {
		System.out.println("---------------");
		System.out.println("comedy show plays");
	}
	
	public void playConcert() {
		System.out.println("---------------");
		System.out.println("concert show plays");
	}
	
	public void runAmusementPark() {
		System.out.println("---------------");
		System.out.println("amusement park plays");
	}
}
