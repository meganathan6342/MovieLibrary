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

@WebServlet("/deleteMovie")
public class deleteMovie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		try {
			HttpSession session = req.getSession();
			String adminemail = (String) session.getAttribute("adminemail");
			System.out.println(adminemail);

			if (adminemail != null) {
				movieDAO m = new movieDAO();
				m.deleteMovie(id);

				req.setAttribute("movies", m.getAllMovies());
				RequestDispatcher rd = req.getRequestDispatcher("adminPage.jsp");
				rd.include(req, resp);
			} else {
				req.setAttribute("message", "Access denied !  admin login is required...");
				RequestDispatcher rd = req.getRequestDispatcher("adminLogIn.jsp");
				rd.include(req, resp);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
