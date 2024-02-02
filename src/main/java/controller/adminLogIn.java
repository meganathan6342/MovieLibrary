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

@WebServlet("/adminLogIn")
public class adminLogIn extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		String aemail = req.getParameter("email");
		String apassword = req.getParameter("password");

		adminDAO a2 = new adminDAO();
		movieDAO mdao = new movieDAO();

		try {
			adminDTO admin = a2.findByEmail(aemail);
			if (admin.getAdminemail()!= null) {
				if (admin.getAdminpassword().equals(apassword)) {
					HttpSession session = req.getSession();
					session.setAttribute("adminemail", admin.getAdminemail());
					req.setAttribute("admin", admin);
					req.setAttribute("movies",mdao.getAllMovies());
					RequestDispatcher dispatcher= req.getRequestDispatcher("adminPage.jsp");
					dispatcher.include(req, resp);
				}else {
					req.setAttribute("message","wrong password");
					RequestDispatcher dispatcher= req.getRequestDispatcher("adminLogIn.jsp");
					dispatcher.include(req, resp);
				}
				
			}else {
				req.setAttribute("message","wrong Email");
				RequestDispatcher dispatcher= req.getRequestDispatcher("adminLogIn.jsp");
				dispatcher.include(req, resp);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
