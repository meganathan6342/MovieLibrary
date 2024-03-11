package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.movieDAO;
import DTO.movieDTO;

@WebServlet("/saveMovie")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024)
public class saveMovie extends HttpServlet{

	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		int movieid = Integer.parseInt(req.getParameter("movieid"));
		String moviename = req.getParameter("moviename");
		double movierating = Double.parseDouble(req.getParameter("movierating"));
		double movieprice = Double.parseDouble(req.getParameter("movieprice"));
		String moviegenre = req.getParameter("moviegenre");
		String movielanguage = req.getParameter("movielanguage");
		Part imagepart = req.getPart("movieimage");
		
		movieDTO m1 = new movieDTO();
		
		m1.setMovieid(movieid);
		m1.setMoviename(moviename);
		m1.setMovierating(movierating);
		m1.setMovieprice(movieprice);
		m1.setMoviegenre(moviegenre);
		m1.setMovielanguage(movielanguage);
		m1.setMovieimage(imagepart.getInputStream().readAllBytes());
		
		movieDAO m2 = new movieDAO();
		
		int res =  m2.saveMovie(m1);
		
		if(res > 0)
		{
			req.setAttribute("movies", m2.getAllMovies());
			
			RequestDispatcher rd = req.getRequestDispatcher("adminPage.jsp");
			rd.include(req, resp);
		}
		else
		{
			req.setAttribute("message", "Movie Id or movie is already presented..");
		}
		
		
	}
}
