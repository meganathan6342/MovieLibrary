package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.adminDAO;
import DTO.adminDTO;



@WebServlet("/adminServlet")
public class adminSignUp extends HttpServlet{

	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		  int aid = Integer.parseInt(req.getParameter("id"));
		  String aname = req.getParameter("name");
		  long acontact = Long.parseLong(req.getParameter("contact"));
		  String aemail = req.getParameter("email");
		  String apassword = req.getParameter("password");
		  
		  adminDTO a1 = new adminDTO();
		  a1.setAdminid(aid);
		  a1.setAdminname(aname);
		  a1.setAdmincontact(acontact);
		  a1.setAdminemail(aemail);
		  a1.setAdminpassword(apassword);
		  
		  adminDAO a2 = new adminDAO();
		  
		  int res = a2.saveAdmin(a1);
		
		if(res>0)
		{
			req.setAttribute("message", "sign up is done successfully...");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.include(req, resp);
		}
		else
		{
			req.setAttribute("message", "email id is already presented...");
			RequestDispatcher rd = req.getRequestDispatcher("adminSignUp.jsp");
			rd.include(req, resp);
		}
		  
	}
	  
	  
	  
	  
	  
	 
}
