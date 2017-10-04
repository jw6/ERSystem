package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextVsServletConfig extends HttpServlet{

	
	/*
	 * URL: /contextVsConfig 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("ServletContextVsServletConfig -GET");
		
		//ServletConfig - configuration for a single servlet
		String servletColor = getServletConfig().getInitParameter("color");
		System.out.println("ServletContextVsServletConfig's Color: " + servletColor);
		
		
		//ServletContext - environment variables for ALL servlets
		String allServletsVersion = getServletContext().getInitParameter("version");
		System.out.println("Servlets' Version: " + allServletsVersion);
	}
	
}
