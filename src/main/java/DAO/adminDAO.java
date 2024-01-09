package DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.adminDTO;

public class adminDAO {
     public Connection getConnection() throws ClassNotFoundException, SQLException
     {
    	 Driver d = new com.mysql.cj.jdbc.Driver();
    	 DriverManager.deregisterDriver(d);
    	 return DriverManager.getConnection("jdbc:mysql://localhost:3306/ottplatform","root","root");
     }
     
     public int saveAdmin(adminDTO a) 
     {
    	 int res=0;
    	 try
    	 {
    		 Connection con = getConnection();
        	 
        	 PreparedStatement st = con.prepareStatement("insert into admin values(?, ?, ?, ?, ?)");
        	 st.setInt(1, a.getAdminid());
        	 st.setString(2, a.getAdminname());
        	 st.setLong(3, a.getAdmincontact());
        	 st.setString(4, a.getAdminemail());
        	 st.setString(5, a.getAdminpassword());
        	 
        	 res = st.executeUpdate();
        	 con.close();
    	 }
    	 catch (ClassNotFoundException | SQLException e) 
    	{
			/* e.printStackTrace(); */
		}
    	 
    	 return res;
     }
     
     public adminDTO findByEmail(String email) throws ClassNotFoundException, SQLException 
     {
    	 
			
			Connection con = getConnection();
	    	 
	    	PreparedStatement st = con.prepareStatement("select * from admin where adminemail = ?");
	    	
	    	st.setString(1, email);
	    	 
	    	 ResultSet rs = st.executeQuery();
	    	 
	    	 adminDTO a = new adminDTO();
	    	 while(rs.next())
	    	 {
	    		a.setAdminid(rs.getInt(1)); 
	    		a.setAdminname(rs.getString(2));
	    		a.setAdmincontact(rs.getLong(3));
	    		a.setAdminemail(rs.getString(4));
	    		a.setAdminpassword(rs.getString(5));
	    	 }
	    	 con.close();
	    	 
    	 return a;
     }
     
     
     
     
     
     
     
     
     
     
     
}
