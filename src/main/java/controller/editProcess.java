package controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import DAO.movieDAO;
import DTO.movieDTO;

@WebServlet("/editProcess")
@MultipartConfig(maxFileSize = 5*1024*1024)
public class editProcess extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  int movieid = Integer.parseInt(req.getParameter("movieid"));
		  String moviename = req.getParameter("moviename");
		  double movierating = Double.parseDouble(req.getParameter("movierating"));
		  double movieprice = Double.parseDouble(req.getParameter("movieprice"));
		  String moviegenre = req.getParameter("moviegenre");
		  String movielanguage = req.getParameter("movielanguage");
		  Part movieimage = req.getPart("movieimage");
		  
		  movieDTO m1 = new movieDTO();
		  
		  m1.setMovieid(movieid);
		  m1.setMoviename(moviename);
		  m1.setMovierating(movierating);
		  m1.setMovieprice(movieprice);
		  m1.setMoviegenre(moviegenre);
		  m1.setMovielanguage(movielanguage);
		  m1.setMovieimage(movieimage.getInputStream().readAllBytes());
		  
		  movieDAO m2 = new movieDAO();
		  
		  try {
			  
			int res = m2.editMovie(m1);
			
			if(res > 0)
			{
				req.setAttribute("movies", m2.getAllMovies());
				RequestDispatcher rd = req.getRequestDispatcher("adminPage.jsp");
				rd.include(req, resp);
			}
			else
			{
				req.setAttribute("movie", m2.findById(movieid));
				req.setAttribute("message", "edit process is not done properly");
				RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
				rd.include(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		    
		  
		  
		  
	}
}
