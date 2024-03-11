package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.movieDAO;
import DAO.userDAO;
import DTO.userDTO;

@WebServlet("/userNPWProcess")
public class userNPWProcess extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String useremail = req.getParameter("useremail");
		String userpassword = req.getParameter("userpassword");
		String newpass = req.getParameter("newpass");
		String confirmpass = req.getParameter("confirmpass");
		
		userDAO u1 = new userDAO();
		
		try {
			
			userDTO u2 = u1.findByEmail(useremail);
			
			if(u2.getUseremail().equals(useremail) && u2.getUserpassword().equals(userpassword))
			{
				if(newpass.equals(confirmpass))
				{
					int res = u1.changePassword(useremail, confirmpass);
					
					if(res > 0)
					{
						req.setAttribute("message", "password has been changed successfully..");
						RequestDispatcher rd = req.getRequestDispatcher("userLogIn.jsp");
						rd.include(req, resp);
					}
					
				}
				else
				{
					req.setAttribute("admin", u2);
					req.setAttribute("message", "confirm password is wrong");
					RequestDispatcher rd = req.getRequestDispatcher("userNPWProcess.jsp");
					rd.include(req, resp);
				}
			}
			else
			{
				req.setAttribute("user", u2);
				req.setAttribute("message", "old password is wrong");
				RequestDispatcher rd = req.getRequestDispatcher("userNPWProcess.jsp");
				rd.include(req, resp);	
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
