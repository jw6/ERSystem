package com.revature.main;

import java.util.Scanner;

import com.revature.exceptions.UserInfoException;
import com.revature.models.BankUser;
import com.revature.models.UserLoginInfo;
import com.revature.service.Service;

public class MainClass {
	private static Scanner sc = new Scanner(System.in);
	private static Service service = new Service();
	
	public static void main(String[] args) {
		System.out.println("Welcome to Virtual Bank!");
		System.out.println("What would you like to do?");
		System.out.println("[1]\tLogin");
		System.out.println("[2]\tRegister");
		
		int status = sc.nextInt();
		
		boolean flag = true;
		while(flag) {
			switch(status){
				case 1:
					System.out.println("Please enter your username and password now");
					String username = sc.next();
					String password = sc.next();
						
					if(username != "") {
						if(password != "") {
							MainClass mc = new MainClass(username, password);
						} else {
							System.out.println("Password cannot be empty!");
						}
					} else {
						System.out.println("Username cannot be empty");
					}
	
					break;
				case 2:
					break;
				default:
					System.out.println("Please choose a valid option to continue");
					break;
			}
			flag = false;
		}
		
	}
	public MainClass(String username, String password) {
		service.userLogin(username, password);
		mainMenu();
	}
	
	public void mainMenu() {
		int exit = 0;
		System.out.println("Enter your User ID, first name and last name to view account and balance");
		int bankUserID = sc.nextInt();
		String firstName = sc.next();
		String lastName = sc.next();
		BankUser user = new BankUser(bankUserID, firstName, lastName);
		service.getBankAccountByUser(user);
		while(exit == 0) {
			System.out.println("Enter your Account ID to Proceed");
//			int accountID = 
		}
	}
}
