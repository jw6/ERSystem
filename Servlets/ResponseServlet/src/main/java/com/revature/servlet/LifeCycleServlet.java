package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class LifeCycleServlet extends HttpServlet{

	/*
	 * URL: /lifeCycle
	 * 
	 *  LifeCycle:
	 *  	init()
	 *  	service()
	 *  	destroy()
	 *  
	 *  "Lazy Loading" servlets, waiting for the first request
	 *  "Eagerly Loading" servlets, load-on-startup tag in web.xml 
	 * 
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("LifeCycleServlet -GET");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("lifeCycle -service()");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		System.err.println("lifeCycle -destroy()");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.err.println("lifeCycle -init()");
		super.init();
	}
}
