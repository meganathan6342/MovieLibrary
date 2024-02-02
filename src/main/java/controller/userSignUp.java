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

@WebServlet("/userSignUp")
public class userSignUp extends HttpServlet{

	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		   int userid = Integer.parseInt(req.getParameter("userid"));
		   String username = req.getParameter("username");
		   long usercontact = Long.parseLong(req.getParameter("usercontact"));
		   String useremail = req.getParameter("useremail");
		   String userpassword = req.getParameter("userpassword");
		   
		   userDTO u1 = new userDTO();
		   u1.setUserid(userid);
		   u1.setUsername(username);
		   u1.setUsercontact(usercontact);
		   u1.setUseremail(useremail);
		   u1.setUserpassword(userpassword);
		   
		   userDAO u2 = new userDAO();
		   
		   int res;
		try {
			
			res = u2.saveUser(u1);
			if(res>0)
			   {
				   req.setAttribute("message", "Sign Up is done suceessfully..!");
				   RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				   rd.include(req, resp);
			   }
			   else
			   {
				   req.setAttribute("message", "User ID or Email is already presented..");
				   RequestDispatcher rd = req.getRequestDispatcher("userSignUp.jsp");
				   rd.include(req, resp);
			   }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   	   
	}
}
