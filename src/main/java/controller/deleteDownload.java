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

@WebServlet("/deleteDownload")
public class deleteDownload extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  int movieid = Integer.parseInt(req.getParameter("id"));
		  String useremail = req.getParameter("user");
		  
		  movieDAO m = new movieDAO();
		  try {
			
			  m.deleteDownload(movieid, useremail);
			  
			  req.setAttribute("user", useremail);
			  req.setAttribute("downloads", new movieDAO().getAllDownloads(useremail));
			  req.setAttribute("message", "there is no download..");
			  RequestDispatcher rd = req.getRequestDispatcher("gettingDownloads.jsp");
			  rd.include(req, resp);
			  
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
