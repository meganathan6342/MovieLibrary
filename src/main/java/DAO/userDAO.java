package DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.userDTO;

public class userDAO {

	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Driver d = new com.mysql.cj.jdbc.Driver();
   	 DriverManager.deregisterDriver(d);
   	 return DriverManager.getConnection("jdbc:mysql://localhost:3306/ottplatform","root","root");
	}
	public int saveUser(userDTO u) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		
		int res = 0;
		
		try {
			
			PreparedStatement st = con.prepareStatement("insert into user values(?, ?, ?, ?, ?) ");
			
			st.setInt(1, u.getUserid());
			st.setString(2, u.getUsername());
			st.setLong(3, u.getUsercontact());
			st.setString(4, u.getUseremail());
			st.setString(5, u.getUserpassword());
			
			res = st.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public userDTO findByEmail(String email) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		
		userDTO u1 = null;
		PreparedStatement st = con.prepareStatement("select * from user where useremail = ?");
		
		st.setString(1, email);
		
		ResultSet rs = st.executeQuery();
		
		u1 = new userDTO();
		while(rs.next())
		{
			u1.setUserid(rs.getInt(1));
			u1.setUsername(rs.getString(2));
			u1.setUsercontact(rs.getLong(3));
			u1.setUseremail(rs.getString(4));
			u1.setUserpassword(rs.getString(5));
		}
		
		con.close();
		
		return u1;	
	}
	
	public int editUser(userDTO u) throws SQLException, ClassNotFoundException
    {
   	 Connection con = getConnection();
   	 
   	 PreparedStatement st = con.prepareStatement("update user set username = ?, usercontact = ? where useremail = ?");
   	 
   	 st.setString(1, u.getUsername());
   	 st.setLong(2, u.getUsercontact());
   	 st.setString(3, u.getUseremail());
   	 
   	 int res = st.executeUpdate();
   	 return res;
    }
	
	public int changePassword(String email, String pass) throws ClassNotFoundException, SQLException 
	{
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("update user set userpassword = ? where useremail = ?");
		
		st.setString(1, pass);
		st.setString(2, email);
		
		int res = st.executeUpdate();
		
		con.close();
		
		return res;
	}
	
	public int forgotPasssword(userDTO user) throws SQLException, ClassNotFoundException
	{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("update user set userpassword = ? where useremail = ?");
		
		st.setString(1, user.getUserpassword());
		st.setString(2, user.getUseremail());
		
		int res = st.executeUpdate();
		
		con.close();
		
		return res;
	}
}
