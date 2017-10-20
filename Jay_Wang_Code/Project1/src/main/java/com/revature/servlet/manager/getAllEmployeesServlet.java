package com.revature.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.ERSUser;
import com.revature.service.AppService;

/**
 * Servlet implementation class getAllEmployeesServlet
 */
@WebServlet("/getAllEmployees")
public class getAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ERSUser> employees = new AppService().getAllEmployees();
		
		for(ERSUser emp : employees) {
			System.err.println(emp.toString());
		}
		if(employees != null) {
			HttpSession session = request.getSession();
			session.setAttribute("employees", employees);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(employees);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
		}else {
			response.setStatus(418);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
