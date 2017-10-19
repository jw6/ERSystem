package com.revature.servlet.employee;

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
import com.revature.bean.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class loadReimbursementServlet
 */
@WebServlet("/loadReimbursement")
public class loadReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("loadReimbursementServlet -GET");
		
		HttpSession session = request.getSession();
		ERSUser clientUser = (ERSUser) session.getAttribute("user");
		
		List<Reimbursement> rbHistory = new AppService().getAllReimbursements();
		
		for(Reimbursement rb : rbHistory) {
			System.out.println(rb.toString());
		}
		
		if(rbHistory != null) {
			ObjectMapper mapper = new ObjectMapper();
			String json= mapper.writeValueAsString(rbHistory);
			System.err.println(json);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
		} else {
			response.setStatus(418);
		}
	}
}
