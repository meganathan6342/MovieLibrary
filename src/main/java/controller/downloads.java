package controller;

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
import DTO.userDTO;

@WebServlet("/downloads")
public class downloads extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  int movieid = Integer.parseInt(req.getParameter("id"));
		  String useremail = req.getParameter("user");
		  System.out.println(useremail);
		  
		  movieDAO m1 = new movieDAO();
		  
		  userDTO user = new userDTO();
		  user.setUseremail(useremail);
		  try {
			  
			movieDTO m2 = m1.findById(movieid);
			
			boolean value = m1.findDownloadByEmail(user.getUseremail(), movieid);
			System.out.println("movieid : "+ movieid+"\t id : "+value);
			
			if(value)
			{
				int res = m1.saveDownload(m2, user.getUseremail());
				req.setAttribute("downloads", m1.getAllDownloads(user.getUseremail()));
				RequestDispatcher rd = req.getRequestDispatcher("gettingDownloads.jsp");
				rd.include(req, resp);
			}
			else 
			{
				req.setAttribute("message", "movie is already downloaded..");
				req.setAttribute("movies", m1.getAllMovies());
				req.setAttribute("user", user.getUseremail());
				RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
