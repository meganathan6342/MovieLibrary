package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.userDAO;
import DTO.userDTO;

@WebServlet("/velifyContactUFPW")
public class velifyContactUFPW extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String email = req.getParameter("email");
		 // String conntact = req.getParameter("contact");
 		  long contact = Long.parseLong(req.getParameter("contact"));
		  
		  userDAO u1 = new userDAO();
		  
		  try {
			  
			userDTO u2 = u1.findByEmail(email);
			
			if(u2.getUsercontact() == contact)
			{
				req.setAttribute("user", u2);
				RequestDispatcher rd = req.getRequestDispatcher("changeUserPW.jsp");
				rd.include(req, resp);
			}
			else
			{
				req.setAttribute("user", u2);
				req.setAttribute("message", "contact is wrong..");
				RequestDispatcher rd = req.getRequestDispatcher("velifyContactUFPW.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
