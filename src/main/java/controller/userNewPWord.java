package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.userDAO;
import DTO.userDTO;

@WebServlet("/userNewPWord")
public class userNewPWord extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String useremail = req.getParameter("email");
		
		userDAO u1 = new userDAO();
		try {
			
			userDTO u2 = u1.findByEmail(useremail);
			
			req.setAttribute("user", u2);
			RequestDispatcher rd = req.getRequestDispatcher("userNPWProcess.jsp");
			rd.include(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
