package com.revature.main;

import java.util.Date;
import java.util.Scanner;

import com.revature.exceptions.UserInfoException;
import com.revature.models.BankTransaction;
import com.revature.models.BankUser;
import com.revature.models.UserLoginInfo;
import com.revature.service.Service;

public class MainClass {
	private static Scanner sc = new Scanner(System.in);
	private static Service service = new Service();
	private BankTransaction bankTransaction;
	private final static String screenMessage = "What would you like to do?\n"
											+ "[1]Deposit\n" 
											+ "[2]Withdrawal\n"
											+ "[0]Exit";
	
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
	
	//This constructor is coded for register a new user
	public MainClass() {
		
	}
	
	public void mainMenu() {
		int exit = 1;
		System.out.println("Enter your User ID, first name and last name to view account and balance");
		int bankUserID = sc.nextInt();
		String firstName = sc.next();
		String lastName = sc.next();
		BankUser user = new BankUser(bankUserID, firstName, lastName);
		service.getBankAccountByUser(user);
		while(exit != 0) {
			System.out.println(screenMessage);
			int option = sc.nextInt();
			if(option == 1) {
				System.out.println("Enter your account ID and amount to continue\t");
				int accountID = sc.nextInt();
				double amount = sc.nextDouble();
				bankTransaction = new BankTransaction(bankUserID, accountID, option, amount, new Date());
				service.performTransaction(bankTransaction);
			} else if (option == 2) {
				System.out.println("Enter your account ID and amount to continue\t");
				int accountID = sc.nextInt();
				double amount = sc.nextDouble();
				bankTransaction = new BankTransaction(bankUserID, accountID, option, amount, new Date());
				service.performTransaction(bankTransaction);
			}
		}
	}
}
