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
import com.revature.bean.BankAccount;
import com.revature.bean.BankUser;
import com.revature.dto.BankUserDTO;
import com.revature.service.AppService;

/**
 * Servlet implementation class AjaxBankUserInfoServlet
 */
@WebServlet("/ajaxGetBankUserInfo")
public class AjaxBankUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxBankUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AjaxBankUserInfoServlet -Get");
		
		//client wants the BankUser that at this point should be stored in the session
		HttpSession session = request.getSession();

		BankUser clientUser = (BankUser) session.getAttribute("user");
		
		//basic null check
		if(clientUser != null) {
			AppService service = new AppService();
			BankAccount account = service.getBankAccountByUsername(clientUser);
			
			//another basic null check
			if(account != null) {
				/*
				 * 	Convert JavaBean into JSON
				 *	DTO - Data Transfer Object Design for moving objects 
				 */
				System.out.println("----------Converting BankUser & account to DTO");
				BankUserDTO bankUserDto = service.convertToBankUserDTO(clientUser, account);
				
				System.out.println("----------JSON mapping DTO using Jackson");
				ObjectMapper mapper = new ObjectMapper();
				
				String json = mapper.writeValueAsString(bankUserDto);
				PrintWriter out = response.getWriter();
				//best practice
				response.setContentType("application/json");
				out.write(json);
			} else {
				response.setStatus(418);
			}
		}
		//Convert JavaBean intoJSON
		
	}


}
