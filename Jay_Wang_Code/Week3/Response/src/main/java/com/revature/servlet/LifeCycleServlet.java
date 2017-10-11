package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet{
	/*
	 * URL: LifeCycle
	 * 	LifeCycle:
	 * 		init()
	 * 		service()
	 * 		destroy()
	 * 
	 * 	"Lazy loading" servlets, waiting for the first request
	 * 	"Eagerly Loading" servlets, load-on-startup tag in web.xml
	 * 	
	 */
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("LifeCycle -doGet()");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycle -service()");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("LifeCycle -destroy()");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycle -init()");
		super.init();
	}
}
