package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import DTO.movieDTO;

public class movieDAO {

	  public Connection getConnection() throws SQLException, ClassNotFoundException
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  return DriverManager.getConnection("jdbc:mysql://localhost:3306/ottplatform?user=root&password=root");
	  }
	  
	  public int saveMovie(movieDTO m)
	  {
		  
		  int res = 0;
		  
		  try {
			  Connection con = getConnection();
			  
			  PreparedStatement st = con.prepareStatement("insert into movie values(?, ?, ?, ?, ?, ?, ?)");
			  
			  st.setInt(1, m.getMovieid());
			  st.setString(2, m.getMoviename());
			  st.setDouble(3, m.getMovierating());
			  st.setDouble(4, m.getMovieprice());
			  st.setString(5, m.getMoviegenre());
			  st.setString(6, m.getMovielanguage());
			  Blob imageBlob = new SerialBlob(m.getMovieimage());
			  st.setBlob(7, imageBlob);
			  
			  res = st.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			
			//e.printStackTrace();
		}
		  
		  return res;
	  }
	  
	  public List<movieDTO> getAllMovies()
	  {
		  
		  List<movieDTO> l = null;
		  
		  try {
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement("select * from movie");
			
			ResultSet rs = st.executeQuery();
			l = new ArrayList<movieDTO>();
			
			while(rs.next())
			{
				movieDTO m = new movieDTO();
				m.setMovieid(rs.getInt(1));
				m.setMoviename(rs.getString(2));
				m.setMovierating(rs.getDouble(3));
				m.setMovieprice(rs.getDouble(4));
				m.setMoviegenre(rs.getString(5));
				m.setMovielanguage(rs.getString(6));
				Blob b = rs.getBlob(7);
				byte[] img = b.getBytes(1, (int) b.length());
				m.setMovieimage(img);
				
				l.add(m);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return l;
	  }
	  
	  public int deleteMovie(int id) throws ClassNotFoundException, SQLException
	  {
		    
		    Connection con = getConnection();
		    
		    PreparedStatement st = con.prepareStatement("delete from movie where movieid = ?");
		    st.setInt(1, id);
		    
		    int res = st.executeUpdate();
		    
		    con.close();
		    
		    return res;
	  }

	public movieDTO findById(int id) throws ClassNotFoundException, SQLException 
	{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from movie where movieid = ?");
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		movieDTO m = new movieDTO();
		
		while(rs.next())
		{
			m.setMovieid(rs.getInt(1));
			m.setMoviename(rs.getString(2));
			m.setMovierating(rs.getDouble(3));
			m.setMovieprice(rs.getDouble(4));
			m.setMoviegenre(rs.getString(5));
			m.setMovielanguage(rs.getString(6));
			m.setMovieimage(rs.getBlob(7).getBytes(1, (int) rs.getBlob(7).length()));
		}
		
		con.close();
		
		return m;
	}
	
	public void editMovie(movieDTO m) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("update movie set moviename = ?, movierating = ?, movieprice = ?, moviegenre = ?, movielanguage = ?, movieimage = ?  where movieid = ?");
		
		st.setString(1, m.getMoviename());
		st.setDouble(2, m.getMovierating());
		st.setDouble(3, m.getMovieprice());
		st.setString(4, m.getMoviegenre());
		st.setString(5, m.getMovielanguage());
		st.setBlob(6, new SerialBlob(m.getMovieimage()));
		st.setInt(7, m.getMovieid());
		
		Blob b = new SerialBlob(m.getMovieimage());
		
		if(b.length()>1)
		{
			st.setBlob(6, b);
		}
		else
		{
			/*
			 * PreparedStatement st1 =
			 * con.prepareStatement("select movieimage from movie where movieid = ?");
			 * 
			 * st1.setInt(1, m.getMovieid());
			 * 
			 * ResultSet rs = st1.executeQuery();
			 * 
			 * Blob b1 = null;
			 * 
			 * while(rs.next()) { b1 = rs.getBlob(1); }
			 * 
			 * st.setBlob(6, b1);
			 */
			
			movieDTO m1 = findById(m.getMovieid());
			Blob b1 = new SerialBlob(m1.getMovieimage());
			st.setBlob(6, b1);
			
		}
		
		st.executeUpdate();
		
		con.close();
	}

	public int saveDownload(movieDTO m, String useremail) throws ClassNotFoundException, SQLException 
	{
		Connection con = getConnection();
		
		String query = "insert into moviedownloads (moviename, movierating, movieprice, moviegenre, movielanguage, movieimage, useremail, movieid) values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, m.getMoviename());
		st.setDouble(2, m.getMovierating());
		st.setDouble(3, m.getMovieprice());
		st.setString(4, m.getMoviegenre());
		st.setString(5, m.getMovielanguage());
		
		Blob img = new SerialBlob(m.getMovieimage());
		st.setBlob(6, img);
		st.setString(7, useremail);
		st.setInt(8, m.getMovieid());
		
		int res = st.executeUpdate();
		con.close();
		
		return res;
	}

	public boolean findDownloadByEmail(String email, int movieid) throws ClassNotFoundException, SQLException 
	{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select movieid from moviedownloads where useremail = ?");
		st.setString(1, email);
		
		ResultSet rs = st.executeQuery();
		int id = 0;
		while(rs.next())
		{
			id = rs.getInt(1);
			if(movieid == id)
			{
				return false;
			}
		}
		con.close();
		
		return true;
	}
	
	public List<movieDTO> getAllDownloads(String user)
	  {
		List<movieDTO> l = null; 
		  try {
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement("select * from moviedownloads where useremail = ?");
			st.setString(1, user);
			
			ResultSet rs = st.executeQuery();
			l = new ArrayList<movieDTO>();
			
			while(rs.next())
			{
				movieDTO m = new movieDTO();
				m.setMovieid(rs.getInt(9));
				m.setMoviename(rs.getString(2));
				m.setMovierating(rs.getDouble(3));
				m.setMovieprice(rs.getDouble(4));
				m.setMoviegenre(rs.getString(5));
				m.setMovielanguage(rs.getString(6));
				Blob b = rs.getBlob(7);
				byte[] img = b.getBytes(1, (int) b.length());
				m.setMovieimage(img);
				
				l.add(m);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		  
		  return l;
	  }
	
	public int deleteDownload(int id, String user) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("delete from moviedownloads where movieid = ? and useremail = ?");
		st.setInt(1, id);
		st.setString(2, user);
		
		int res = st.executeUpdate();
		con.close();
		
		return res;
	}
	  
}
