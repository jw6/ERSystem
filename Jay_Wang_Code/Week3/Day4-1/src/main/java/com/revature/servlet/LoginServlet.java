package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Random test, -GET()");
//		RequestDispatcher rd = request.getRequestDispatcher("index.html");
//		rd.forward(request, response);
//		request.getRequestDispatcher("index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//HttpSession session = request.getSession();
	// use seesion.invalidate() to kill it
	
	/* Request parameter only live until the response is sent back
	 * If we want to hold data for longer peiods then use
	 * 	HttpSession
	 * Once we start a session with the client, we send the client
	 * 	a cookie called JSESSIONID
	 * Every request following our web container will look for
	 * 	the JESESSIONID cookie
	 * 
	 */

}
