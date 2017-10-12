package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bean.BankUser;
import com.revature.service.AppService;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login")
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
		
		System.out.println("The user enter: " + username + " " + password);
		BankUser clientUser = new BankUser(username, password);
		//4
		clientUser = new AppService().validateUser(clientUser);
		
		if(clientUser != null) {	
			//2 Store the valid user into the Session
			HttpSession session = request.getSession();
			session.setAttribute("user", "clientUser");
			
			
			//1 validated user sent to app.html
			request.getRequestDispatcher("app.html").forward(request, response);
		} else {
			doGet(request, response);
		}
//		
//		//2 Store the valid user into the Session
//		HttpSession session = request.getSession();
//		session.setAttribute("user", "clientUser");
//		
//		
//		//1 validated user sent to app.html
//		request.getRequestDispatcher("app.html").forward(request, response);
	} 

}
