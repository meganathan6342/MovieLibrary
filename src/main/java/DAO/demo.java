package DAO;

import java.sql.SQLException;

import DTO.adminDTO;

public class demo {
   
	  public static void main(String[] args) throws ClassNotFoundException, SQLException {
		  String email = "meganathanr2000@gmail.com";
		  adminDAO a2 = new adminDAO();
		  adminDTO a1 = a2.findByEmail(email);
		  System.out.println(a1);
	}
}
