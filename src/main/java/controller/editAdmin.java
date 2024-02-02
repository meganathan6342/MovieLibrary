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

import DAO.adminDAO;
import DAO.movieDAO;
import DTO.adminDTO;

@WebServlet("/editAdmin")
public class editAdmin extends HttpServlet{

	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String adminemail = req.getParameter("adminemail");
		  String adminname = req.getParameter("adminname");
		  long admincontact = Long.parseLong(req.getParameter("admincontact"));
		  
		  adminDTO a1 = new adminDTO();
		  a1.setAdminemail(adminemail);
		  a1.setAdminname(adminname);
		  a1.setAdmincontact(admincontact);
		  
		  HttpSession session = req.getSession();
		  String mail = (String) session.getAttribute("adminemail");
		  
		  if(mail!=null)
		  {
			  try {
				  
				  adminDAO a2 = new adminDAO();
				  int res = a2.editAdmin(a1);
				  
				  if(res > 0)
				  {
					  req.setAttribute("movies", new movieDAO().getAllMovies());
					  adminDTO a3 = a2.findByEmail(adminemail);
					  req.setAttribute("admin", a3);
					  RequestDispatcher rd = req.getRequestDispatcher("adminPage.jsp");
					  rd.include(req, resp);
				  }
				  else
				  {
					  req.setAttribute("message", "edit is not done");
					  RequestDispatcher rd = req.getRequestDispatcher("editAdmin.jsp");
					  rd.include(req, resp);
				  }
				  
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	}
}
