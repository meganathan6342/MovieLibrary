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

@WebServlet("/changeAdminPW")
public class changeAdminPW extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String email = req.getParameter("email");
		  String newpass = req.getParameter("newpass");
		  String confirmpass = req.getParameter("confirmpass");
		  
		  adminDTO a1 = new adminDTO();
		  a1.setAdminemail(email);
		  a1.setAdminpassword(confirmpass);
		  
		  if(newpass.equals(confirmpass))
		  {
			  
			  adminDAO a2 = new adminDAO();
			  
			  try {
				  int res = a2.forgotPasssword(a1);
				if(res > 0)
				  {
					  req.setAttribute("message", "password has been changed successfully..");
					  RequestDispatcher rd = req.getRequestDispatcher("adminLogIn.jsp");
					  rd.include(req, resp);
				  }
				else
				{
					  req.setAttribute("admin", a1);
					  req.setAttribute("message", "somthing went wrong..");
					  RequestDispatcher rd = req.getRequestDispatcher("changeAdminPW.jsp");
					  rd.include(req, resp);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  else
			{
				  req.setAttribute("admin", a1);
				  req.setAttribute("message", "confirm password is wrong..");
				  RequestDispatcher rd = req.getRequestDispatcher("changeAdminPW.jsp");
				  rd.include(req, resp);
			}
	}
}
