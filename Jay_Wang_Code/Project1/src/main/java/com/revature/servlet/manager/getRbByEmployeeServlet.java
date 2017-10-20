package com.revature.servlet.manager;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.ERSUser;
import com.revature.bean.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class getRbByEmployeeServlet
 */
@WebServlet("/getRbByEmployee")
public class getRbByEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getRbByEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("GetRbsPerEmployeeServlet -POST");
		Map<String, String[]> myMap = request.getParameterMap();
		Set<String> empObject = myMap.keySet();
		Object obj = empObject.toArray()[0];
		ERSUser employee = new ObjectMapper().readValue((String)obj, ERSUser.class);
		List<Reimbursement> rbs = new AppService().getReimbursementsByEmployee(employee);
		String json = new ObjectMapper().writeValueAsString(rbs);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
