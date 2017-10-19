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
		System.out.println("EmployeeUpdateServlet -POST");

		Map<String, String[]> map = request.getParameterMap();
		Set<String> info = map.keySet();
		ObjectMapper mapper = new ObjectMapper();
		Object obj = info.toArray()[0];
		ERSUser clientUser = mapper.readValue(((String)obj), ERSUser.class);

		AppService service = new AppService();
		int status = service.updateEmployeeInfo(clientUser);

		if(status == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("user", clientUser);
		} else {
			request.getRequestDispatcher("features/views/editEmployeeInfo.html").forward(request, response);
		}
	}

}
