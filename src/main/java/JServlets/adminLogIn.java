package JServlets;

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

@WebServlet("/adminLogIn")
public class adminLogIn extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		 
		  String aemail = req.getParameter("email");
		  String apassword = req.getParameter("password");
		  
		  adminDAO a2 = new adminDAO();
		  
		  adminDTO a1 = null;
		try {
			a1 = a2.findByEmail(aemail);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		if(a1.getAdminemail()!=null)
		{
			if(a1.getAdminpassword().equals(apassword))
			{
				movieDAO m = new movieDAO();
				req.setAttribute("movies", m.getAllMovies());
				
				RequestDispatcher rd = req.getRequestDispatcher("adminHome.jsp");
				try {
					rd.include(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
			else
			{
				req.setAttribute("message", "password is wrong");
				RequestDispatcher rd = req.getRequestDispatcher("adminLogIn.jsp");
				try {
					rd.include(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}
		else
		{
			req.setAttribute("message", "email is wrong");
			RequestDispatcher rd = req.getRequestDispatcher("adminLogIn.jsp");
			try {
				rd.include(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
