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

@WebServlet("/userLogIn")
public class userLogIn extends HttpServlet{

	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
		   String useremail = req.getParameter("useremail");
		   String userpassword = req.getParameter("userpassword");
		   
		   userDAO u1 = new userDAO();
		   
		try {
			
			userDTO u2 = u1.findByEmail(useremail);
			
			if(u2.getUseremail()!=null)
			   {
				   if(u2.getUserpassword().equals(userpassword))
				   {
					   req.setAttribute("user", useremail);
					   RequestDispatcher rd = req.getRequestDispatcher("gettingMovies");
					   try {
						rd.include(req, resp);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   }
				   else
				   {
					   req.setAttribute("message", "password is wrong...");
					   RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					   try {
						rd.include(req, resp);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   }
			   }
			   else
			   {
				   req.setAttribute("message", "Email is wrong...");
				   RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				   try {
					rd.include(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
	}
}
