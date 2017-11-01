package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OprRecordUpdate")
public class OprRecordUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oprUsername = request.getParameter("oprUsername");

		String oprLastName = request.getParameter("oprLastName");

		String oprFirstName = request.getParameter("oprFirstName");
		
		String addLine1 = request.getParameter("addLine1");

		String addLine2 = request.getParameter("addLine2");

		String city = request.getParameter("city");
		
		String zipcode = request.getParameter("zipcode");

		String emailAdd1 = request.getParameter("emailAdd1");

		String emailAdd2 = request.getParameter("emailAdd2");
		
		String mobileNo = request.getParameter("mobileNo");

		try{
		Database.updateOprRecord(oprUsername, oprLastName, oprFirstName, addLine1, addLine2, city, zipcode, emailAdd1, emailAdd2, mobileNo);
		request.getSession().setAttribute("updateOprMsgSuccess", "Doctor's Record Updated");
		}catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("updateOprMsgUnSuccess", "Unable to update Doctor's record");
		}
		response.sendRedirect("	RolesRegisteration.jsp");
	}

}
