package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.beans.CocoaBean;

public class LoginCtrl{

	/*
	 *  url /login
	 */ 
	public static String login(HttpServletRequest req){
		//Set a Bean for the request object in the home.jsp
		CocoaBean cb = new CocoaBean();
		cb.setFlavor("Java");
		cb.setId(3);
		req.setAttribute("dayFlavor", cb);
		
		//Store user information into the Session
		HttpSession session = req.getSession();
		
		session.setAttribute("current_user", new CocoaBean());
		System.out.println(req.getParameter("username") + " login");
		return "home.jsp";
	}
}
