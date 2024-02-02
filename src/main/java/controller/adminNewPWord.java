package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.adminDAO;
import DAO.movieDAO;
import DTO.adminDTO;

@WebServlet("/adminNewPWord")
public class adminNewPWord extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String adminemail = req.getParameter("email");
		
		adminDAO a1 = new adminDAO();
		try {
			
			adminDTO a2 = a1.findByEmail(adminemail);
			
			req.setAttribute("admin", a2);
			RequestDispatcher rd = req.getRequestDispatcher("adminNPWProcess.jsp");
			rd.include(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
