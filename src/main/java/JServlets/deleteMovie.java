package JServlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.movieDAO;

@WebServlet("/deleteMovie")
public class deleteMovie extends HttpServlet{

	  @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  int id = Integer.parseInt(req.getParameter("id"));
		  
		  movieDAO m = new movieDAO();
		  
		  try {
			  
			int res = m.deleteMovie(id);
			
			if(res>0)
			{
				req.setAttribute("movies", m.getAllMovies());
				RequestDispatcher rd = req.getRequestDispatcher("adminHome.jsp");
				rd.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "delete is not done properly...");
				RequestDispatcher rd = req.getRequestDispatcher("adminHome.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
	}
}
