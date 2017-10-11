package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardVsRedirectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		/*
		 * URL: /forwardVSRedirect
		 * 
		 * 3 ways to handle a request and send back a response
		 * 		1. PrintWriter: respond directly from a servlet
		 * 		2. Forward: stay on the server, send the request&response to another location
		 * 			that location will provide the response
		 * 		3. Redirect: sends an address back to the client and 
		 * 			forces the client to request the new address (URL)
		 * 			2.Request, 2.Response
		 * 		
		 */
		
		System.out.println("ForwardVsRedirectServlet");
		
//	 	RequestDispatcher rd = req.getRequestDispatcher("home.html");
//	 	rd.forward(req, resp);
//	 	
	 	//SendRedicret
//	 	resp.sendRedirect("login");
	 	resp.sendRedirect("Home.html");
	}
}
