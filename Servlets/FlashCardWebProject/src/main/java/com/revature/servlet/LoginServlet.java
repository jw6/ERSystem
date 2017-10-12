package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet -GET");
//		RequestDispatcher rd = request.getRequestDispatcher("index.html");
//		rd.forward(request, response);
		
		request.getRequestDispatcher("index.html").forward(request, response); //method chaining
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet -POST");
		String username = request.getParameter("username");
		String pw = request.getParameter("password");
		
		System.out.println("The user entered: " + username + " " + pw);
		
		/*
		 *  	Code code code
		 *  call service to validate user 
		 * 
		 */
		HttpSession session = request.getSession();
		session.setAttribute("user", username);
		session.setAttribute("pw", pw);
		/*
		 *  Request parameter only live until the response is sent back
		 *  If we want to hold data for longer periods then use
		 *  	HttpSession
		 *  Once we start a session with the client, we send the client
		 *  	a cookie called JSESSIONID
		 *  Every request following our web container will look for
		 *  	the JSESSID cookie
		 */
//		session.`
//		request.getRequestDispatcher("home.jsp").forward(request, response);
		response.sendRedirect("home.jsp");
	}

}











