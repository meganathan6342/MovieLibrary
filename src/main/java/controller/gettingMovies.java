package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.movieDAO;
import DTO.movieDTO;

@WebServlet("/gettingMovies")
@MultipartConfig(maxFileSize = 5*1024*1024)
public class gettingMovies extends HttpServlet{

	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		  movieDAO m1 = new movieDAO();
		  List<movieDTO> m2 = m1.getAllMovies();
		  String useremail = (String) req.getAttribute("user");
		  req.setAttribute("movies", m2);
		  req.setAttribute("user", useremail);
		  RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
		  rd.include(req, resp);
	}
}
