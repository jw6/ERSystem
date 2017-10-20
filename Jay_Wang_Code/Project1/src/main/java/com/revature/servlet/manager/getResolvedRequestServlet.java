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
 * Servlet implementation class getResolvedRequestServlet
 */
@WebServlet("/getResolvedRequest")
public class getResolvedRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getResolvedRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.err.println(" getResolvedRequestServlet -GET");
		List<Reimbursement> rbs = new AppService().getAllReimbursements();
		List<Reimbursement> resolved = new ArrayList<>();
		
		if(rbs != null) {
			request.getSession().setAttribute("reimbursements", rbs);
			for(Reimbursement rb : rbs) {
				if(rb.getStId() == 2 || rb.getStId() == 3) {
					resolved.add(rb);
				}
			}
			request.getSession().setAttribute("resolved", resolved);
			String json = new ObjectMapper().writeValueAsString(resolved);
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
