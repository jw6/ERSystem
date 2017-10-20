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
import com.revature.bean.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class getAllReimbursementsServlet
 */
@WebServlet("/getAllReimbursements")
public class getAllReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllReimbursementsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("getAllReimbursementsServlet -GET");
		
		List<Reimbursement> rbs = new AppService().getAllReimbursements();
		for(Reimbursement rb : rbs) {
			System.err.println(rb.toString());
		}
		if(rbs != null) {
			HttpSession session = request.getSession();
			session.setAttribute("reimbursements", rbs);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(rbs);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
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
