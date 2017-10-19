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
import com.revature.bean.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class submitRequestBtnServlet
 */
@WebServlet("/submitRequestBtn")
public class submitRequestBtnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitRequestBtnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("submitRequestBtnServlet -POST");
		
		Map<String, String[]> map = request.getParameterMap();
		Set<String> info = map.keySet();
		ObjectMapper mapper = new ObjectMapper();
		Object obj = info.toArray()[0];
		Reimbursement rb = mapper.readValue(((String)obj), Reimbursement.class);
		System.err.println("testing: " + rb.toString());
		rb.setStId(1);
		AppService service = new AppService();
		
		
		int status = service.submitRequest(rb);
		if(status == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("reimbursement", rb);
		} else {
			request.getRequestDispatcher("employee.html").forward(request, response);
		}
		
	}

}
