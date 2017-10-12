package com.revature.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter{

	@Override
	public void destroy() {
		System.err.println("Destroying MyFilter");
	}

	@Override
	public void doFilter(ServletRequest servlet_request, ServletResponse servlet_response, FilterChain chain)
			throws IOException, ServletException {
		//ServletRequest can be casted down to HttpServletRequest
		HttpServletRequest request = (HttpServletRequest) servlet_request;
		HttpServletResponse response = (HttpServletResponse) servlet_response;
		
		//Grab the session without creating a new one using false
		HttpSession session = request.getSession(false);
		boolean logged_in = false;
		
		if(session != null){
			Object session_attribute = session.getAttribute("current_user");
			if(session_attribute != null){
				request.setAttribute("current_user", session_attribute);
				logged_in = true;
			}
		}
		if(logged_in){
			//Go to where you were going as the user is valid
			chain.doFilter(servlet_request, servlet_response);
		}else{
			response.sendRedirect("form.html");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.err.println("init MyFilter");
		
	}

}
