package com.revature.servlet.employee;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

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
 * Servlet implementation class updateEmployeeInfo
 */
@WebServlet("/updateEmployeeInfo")
public class updateEmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateEmployeeInfo() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("EmployeeUpdateServlet -POST");

		//Grab all paramenters, in this case only 1 JSON String
		Map<String, String[]> myMap = request.getParameterMap();

		//Get the the keySet from the map, returns a Set
		Set<String> empObject = myMap.keySet();

		//API for converting our JSON into a Java Object
		ObjectMapper jackson = new ObjectMapper();

		//Convert the the keySet into an array, then get the first element (index 0) from that set
		Object obj = empObject.toArray()[0];

		//Convert the JSON String into the Class specified in the second argument
		ERSUser employee = jackson.readValue(((String)obj), ERSUser.class);

		AppService service = new AppService();
		/*
		 *
		 * use service class to process the transaction
		 */

		int status = service.updateEmployeeInfo(employee);

		if(status == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("user", employee);
		} else {
			request.getRequestDispatcher("features/views/editEmployeeInfo.html").forward(request, response);
		}
	}

}
