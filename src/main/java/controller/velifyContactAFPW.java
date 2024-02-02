package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.adminDAO;
import DTO.adminDTO;

@WebServlet("/velifyContactAFPW")
public class velifyContactAFPW extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String email = req.getParameter("email");
		 // String conntact = req.getParameter("contact");
 		  long contact = Long.parseLong(req.getParameter("contact"));
		  
		  System.out.println(email+"\t"+contact);
		  
		  adminDAO a1 = new adminDAO();
		  
		  try {
			  
			adminDTO a2 = a1.findByEmail(email);
			
			if(a2.getAdmincontact() == contact)
			{
				System.out.println("hi1");
				req.setAttribute("admin", a2);
				RequestDispatcher rd = req.getRequestDispatcher("changeAdminPW.jsp");
				rd.include(req, resp);
			}
			else
			{
				req.setAttribute("admin", a2);
				req.setAttribute("message", "contact is wrong..");
				RequestDispatcher rd = req.getRequestDispatcher("velifyContactAFPW.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
