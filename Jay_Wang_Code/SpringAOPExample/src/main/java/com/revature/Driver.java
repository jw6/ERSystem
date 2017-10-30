package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.AppService;

public class Driver {
	public static void main(String[] args) {
		System.out.println("spring aop");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		AppService app = (AppService) ac.getBean("appService");
		app.playComedyShow();
		app.playConcert();
		app.runAmusementPark();
	}
}
