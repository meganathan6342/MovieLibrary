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
import DTO.movieDTO;

@WebServlet("/editMovie")
public class editMovie extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  int movieid = Integer.parseInt(req.getParameter("id"));
		  
		  movieDTO m1 = new movieDTO();
		  m1.setMovieid(movieid);
		  
		  movieDAO m2 = new movieDAO();
		  
		  try {
			  
			req.setAttribute("movie", m2.findById(movieid));
			
			RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
			rd.include(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
