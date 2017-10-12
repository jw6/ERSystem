package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.GetAllBeansCtrl;
import com.revature.controllers.LoginCtrl;
import com.revature.dao.CocoaDAO;
import com.revature.dao.CocoaDAOImpl;

public class RequestHelper
{
	private CocoaDAO dao;
	
	public String process(HttpServletRequest request, HttpServletResponse response)	{
		
		System.out.println("Request Helper process was called: "+request.getRequestURI());
		dao = new CocoaDAOImpl();
		
		switch(request.getRequestURI())
		{
		case "/FrontController/home.do":
			request.setAttribute("dayFlavor", dao.getById(2));
			return "home.jsp";
		case "/FrontController/beans.do":
			return GetAllBeansCtrl.getAllBeans(request, response);
		case "/FrontController/login":	//not login.do as that would be blocked by filter!
			return LoginCtrl.login(request);
		default:
			return "404.jsp";
		}
	}
}
