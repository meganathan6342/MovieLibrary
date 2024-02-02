package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logOut")
public class logOut extends HttpServlet{

	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  HttpSession session = req.getSession(false);
		  session.invalidate();
		  
		  req.setAttribute("message", "session has'en ended...");
		  RequestDispatcher rd = req.getRequestDispatcher("adminLogIn.jsp");
		  rd.include(req, resp);
	}
}
