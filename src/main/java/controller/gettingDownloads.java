package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.movieDAO;
import DTO.movieDTO;

@WebServlet("/gettingDownloads")
public class gettingDownloads extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String useremail = req.getParameter("email");
		
		movieDAO m1 = new movieDAO();
		List<movieDTO> l = m1.getAllDownloads(useremail);
		
		req.setAttribute("message", "there is no download..");
		req.setAttribute("user", useremail);
		req.setAttribute("downloads", l);
		RequestDispatcher rd = req.getRequestDispatcher("gettingDownloads.jsp");
		rd.include(req, resp);
	}
}
