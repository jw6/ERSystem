package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.request.RequestHelper;

/*
 * FrontController Design Pattern
 * 		This MasterServlet will handle ALL requests
 */

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("Request sent to doGet in Front Controller");
		String rh = new RequestHelper().process(request, response);
		request.getRequestDispatcher(rh).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("Request sent to doPost in Front Controller");
		String rh = new RequestHelper().process(request, response);
		request.getRequestDispatcher(rh).forward(request, response);
	}

}
