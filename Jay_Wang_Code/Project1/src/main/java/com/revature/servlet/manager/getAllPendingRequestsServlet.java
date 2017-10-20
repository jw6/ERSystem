package com.revature.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class getAllPendingRequestsServlet
 */
@WebServlet("/getAllPendingRequests")
public class getAllPendingRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllPendingRequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getAllPendingRequestsServlet -GET");
		List<Reimbursement> rbs = new AppService().getAllReimbursements();
		List<Reimbursement> pending = new ArrayList<>();
	
		if(rbs != null) {
			request.getSession().setAttribute("reimbursements", rbs);
			for(Reimbursement rb : rbs) {
				if(rb.getStId() == 1) {
					pending.add(rb);
				}
			}
			request.getSession().setAttribute("pending", pending);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(pending);
			response.setContentType("application/json");
			response.getWriter().write(json);
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
