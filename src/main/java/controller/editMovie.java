package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.movieDAO;
import DTO.adminDTO;
import DTO.movieDTO;

@WebServlet("/editMovie")
public class editMovie extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  int movieid = Integer.parseInt(req.getParameter("id"));
		  
		  try {
			HttpSession session = req.getSession();
			adminDTO adminemail = (adminDTO) session.getAttribute("adminemail");
			
			if(adminemail!=null)
			{
				movieDAO m2 = new movieDAO();
				req.setAttribute("movie", m2.findById(movieid));
				
				RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
				rd.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "login is required..");
				RequestDispatcher rd = req.getRequestDispatcher("adminLogIn.jsp");
				rd.include(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
