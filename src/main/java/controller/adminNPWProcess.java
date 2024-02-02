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
import DAO.movieDAO;
import DTO.adminDTO;

@WebServlet("/adminNPWProcess")
public class adminNPWProcess extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String adminemail = req.getParameter("adminemail");
		String adminpassword = req.getParameter("adminpassword");
		String newpass = req.getParameter("newpass");
		String confirmpass = req.getParameter("confirmpass");
		
		adminDAO a1 = new adminDAO();
		
		try {
			
			adminDTO a2 = a1.findByEmail(adminemail);
			
			if(a2.getAdminemail().equals(adminemail) && a2.getAdminpassword().equals(adminpassword))
			{
				if(newpass.equals(confirmpass))
				{
					int res = a1.changePassword(adminemail, confirmpass);
					
					if(res > 0)
					{
						req.setAttribute("movies", new movieDAO().getAllMovies());
						req.setAttribute("admin", a2);
						req.setAttribute("message", "password has been changed successfully..");
						RequestDispatcher rd = req.getRequestDispatcher("adminLogIn.jsp");
						rd.include(req, resp);
					}
					
				}
				else
				{
					req.setAttribute("admin", a2);
					req.setAttribute("message", "confirm password is wrong");
					RequestDispatcher rd = req.getRequestDispatcher("adminNPWProcess.jsp");
					rd.include(req, resp);
				}
			}
			else
			{
				req.setAttribute("admin", a2);
				req.setAttribute("message", "old password is wrong");
				RequestDispatcher rd = req.getRequestDispatcher("adminNPWProcess.jsp");
				rd.include(req, resp);	
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
