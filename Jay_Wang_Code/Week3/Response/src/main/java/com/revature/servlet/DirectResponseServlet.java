package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DirectResponseServlet extends HttpServlet{
	

	/**
	 * URL: /print
	 * How do we respond directly from a Servlet?
	 * 
	 * Using the PrintWriter Object from the HttpServletResponse
	 * 
	 * Web container provides request and response
	 * 
	 * 
	 */
	private static final long serialVersionUID = -5412834834930747510L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("DirectResponseServlet -GET");
		
		PrintWriter out = resp.getWriter();
		
		out.write("<h1>Use the printWriter to write a message</h1>");
		
	}
}
