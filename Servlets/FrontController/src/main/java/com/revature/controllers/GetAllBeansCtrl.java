package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.CocoaBean;
import com.revature.dao.CocoaDAOImpl;

/*
 *  A Controller Class
 *  	url - /beans.do
 */
public class GetAllBeansCtrl {
	
	//HTTP - GET
	public static String getAllBeans(HttpServletRequest req, HttpServletResponse resp){
		//return all the beans from the dao
		//NOTE: it would be better if called a service to grab beans not the DAO directly
		List<CocoaBean> cocaList = new CocoaDAOImpl().getAll();
		
		//Set a Bean for the request object in the home.jsp
		req.setAttribute("dayFlavor", new CocoaBean());
		
		//Add list of beans into the session
		req.getSession().setAttribute("cocaList", cocaList);
		
		return "home.jsp";
	}

}
