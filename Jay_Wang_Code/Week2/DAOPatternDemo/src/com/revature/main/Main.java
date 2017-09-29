package com.revature.main;
import java.util.Scanner;

import com.revature.pojo.Customer;
import com.revature.service.Service;

public class Main {
	public static void main(String[] args) {
		Customer customer = new Customer();
		Service service = new Service();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What would you like to do?");
		System.out.println("1: Become Customer");
		System.out.println("2: Exit");
		
		int decision = sc.nextInt();
		sc.nextLine();
		
		switch(decision) {
		case 1:
			System.out.println("Enter your fist name");
			String firstName = sc.nextLine();
			System.out.println("Enter your last name");
			String lastName = sc.nextLine();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			service.addCustomer(customer);
		
		case 2:
			break;
		}
	}
}
