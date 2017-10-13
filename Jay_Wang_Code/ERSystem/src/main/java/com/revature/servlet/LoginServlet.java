package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.ERSUser;
import com.revature.service.AppService;

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
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet -POST");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("The user enter: " + username + " " +password);
		
		ERSUser clientUser = new ERSUser(username, password);
		
		clientUser = new AppService().validateUser(clientUser);
		
		if(clientUser != null) {
			//User session to hold this ErsUser object
			HttpSession session = request.getSession();
			session.setAttribute("user", clientUser);
			
			//validated user sent to app.html
			request.getRequestDispatcher("app.html").forward(request, response);
		} else {
			doGet(request, response);
		}
	}

}
