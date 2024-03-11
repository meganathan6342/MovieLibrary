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
import DAO.userDAO;
import DTO.userDTO;

@WebServlet("/editUser")
public class editUser extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String useremail = req.getParameter("useremail");
		  String username = req.getParameter("username");
		  long usercontact = Long.parseLong(req.getParameter("usercontact"));
		  
		  userDTO u1 = new userDTO();
		  u1.setUseremail(useremail);
		  u1.setUsername(username);
		  u1.setUsercontact(usercontact);
		  
		  HttpSession session = req.getSession();
		  String mail = (String) session.getAttribute("useremail");
		  
		  if(mail!=null)
		  {
			  try {
				  
				  userDAO u2 = new userDAO();
				  int res = u2.editUser(u1);
				  userDTO u3 = u2.findByEmail(useremail);
				  
				  if(res > 0)
				  {
					  req.setAttribute("movies", new movieDAO().getAllMovies());
					  req.setAttribute("user", u3.getUseremail());
					  RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
					  rd.include(req, resp);
				  }
				  else
				  {
					  req.setAttribute("user", u3.getUseremail());
					  req.setAttribute("message", "edit is not done");
					  RequestDispatcher rd = req.getRequestDispatcher("editUser.jsp");
					  rd.include(req, resp);
				  }
				  
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	}
}
