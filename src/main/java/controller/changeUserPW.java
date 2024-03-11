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

@WebServlet("/changeUserPW")
public class changeUserPW extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String email = req.getParameter("email");
		  String newpass = req.getParameter("newpass");
		  String confirmpass = req.getParameter("confirmpass");
		  
		  userDTO u1 = new userDTO();
		  u1.setUseremail(email);
		  u1.setUserpassword(confirmpass);
		  
		  if(newpass.equals(confirmpass))
		  {
			  
			  userDAO u2 = new userDAO();
			  
			  try {
				  int res = u2.forgotPasssword(u1);
				if(res > 0)
				  {
					  req.setAttribute("message", "password has been changed successfully..");
					  RequestDispatcher rd = req.getRequestDispatcher("userLogin.jsp");
					  rd.include(req, resp);
				  }
				else
				{
					  req.setAttribute("user", u1);
					  req.setAttribute("message", "somthing went wrong..");
					  RequestDispatcher rd = req.getRequestDispatcher("changeUserPW.jsp");
					  rd.include(req, resp);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  else
			{
				  req.setAttribute("user", u1);
				  req.setAttribute("message", "confirm password is wrong..");
				  RequestDispatcher rd = req.getRequestDispatcher("changeUserPW.jsp");
				  rd.include(req, resp);
			}
	}
}
