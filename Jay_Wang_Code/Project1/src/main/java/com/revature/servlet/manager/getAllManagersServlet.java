package com.revature.servlet.manager;

import java.io.IOException;
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
 * Servlet implementation class getAllManagersServlet
 */
@WebServlet("/getAllManagers")
public class getAllManagersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllManagersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("getAllManagersSerlvet -GET");
		List<ERSUser> managers = new AppService().getAllManagers();
		for(ERSUser manager : managers) {
			System.err.println(manager.toString());
		}
		if(managers != null) {
			HttpSession session = request.getSession();
			session.setAttribute("managers", managers);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(managers);
			response.setContentType("application/json");
			response.getWriter().write(json);
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
