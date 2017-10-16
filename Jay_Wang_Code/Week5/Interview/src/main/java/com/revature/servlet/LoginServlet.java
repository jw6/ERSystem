package com.revature.servlet;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bean.HagenRanchUser;
import com.revature.service.Service;

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
		HagenRanchUser clientUser = new HagenRanchUser(username, password);
		
		clientUser = new Service().validateUser(clientUser);
		System.out.println(clientUser.toString());

		if(clientUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", clientUser);

			if(clientUser.getRoleId() == 1) {
				request.getRequestDispatcher("student.html").forward(request, response);
			} else if(clientUser.getRoleId() == 2) {
				request.getRequestDispatcher("teacher.html").forward(request, response);
			}
		} else {
			doGet(request, response);
		}
		
	}

}
