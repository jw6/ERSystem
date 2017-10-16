package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.HagenRanchUser;
import com.revature.dto.UserDTO;
import com.revature.service.Service;

/**
 * Servlet implementation class StudentInfoServlet
 */
@WebServlet("/ajaxUserInfo")
public class StudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Student Info -GET");
		
		HttpSession session = request.getSession();
		
		HagenRanchUser clientUser = (HagenRanchUser) session.getAttribute("user"); 
		
		if(clientUser != null) {
			UserDTO userdto = new Service().convertToUserDTO(clientUser);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(userdto);
			PrintWriter out = response.getWriter(); 
			
			response.setContentType("application/json");
			out.write(json);
		} else {
			response.setStatus(418);
		}
	}
}
