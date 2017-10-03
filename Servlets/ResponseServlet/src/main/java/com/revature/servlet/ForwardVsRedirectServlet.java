package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardVsRedirectServlet extends HttpServlet{

	/*
	 * URL: /forwardVsRedirect
	 * 
	 * 
	 * 3 ways to handle a request and send back a response
	 * 		1-PrintWriter: respond directly from a servlet
	 * 						1-Request, 1-Response
	 * 		2-Forward: stays on the server, send the the request&response to another location, 
	 * 					that location will provide the response
	 * 						1-Request, 1-Response
	 * 		3-Redirect: sends an address (URL) back to the client and 
	 * 					forces the client to request the new address (URL)
	 * 						2-Request, 2-Response
	 * 
	 */
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("ForwardVsRedirectServlet -GET");
		
		//Forward the Request&Response using teh RequestDispatcher
//		RequestDispatcher rd = req.getRequestDispatcher("home.html");
//		rd.forward(req, resp); //URL is still going to be /forwardVsRedirect
		
		//SendRedirect
//		resp.sendRedirect("https://www.google.com/"); //can be a location outside of the server
//		resp.sendRedirect("login");
		resp.sendRedirect("home.html"); //URL is updated to /home.html
		
		
	}
}
