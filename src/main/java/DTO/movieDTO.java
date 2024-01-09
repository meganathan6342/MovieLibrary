package DTO;

public class movieDTO {
     
	  private int movieid;
	  private String moviename;
	  private double movierating;
	  private double movieprice;
	  private String moviegenre;
	  private String movielanguage;
	  private byte[] movieimage;
	  
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public double getMovierating() {
		return movierating;
	}
	public void setMovierating(double movierating) {
		this.movierating = movierating;
	}
	public double getMovieprice() {
		return movieprice;
	}
	public void setMovieprice(double movieprice) {
		this.movieprice = movieprice;
	}
	public String getMoviegenre() {
		return moviegenre;
	}
	public void setMoviegenre(String moviejoner) {
		this.moviegenre = moviejoner;
	}
	public String getMovielanguage() {
		return movielanguage;
	}
	public void setMovielanguage(String movielanguage) {
		this.movielanguage = movielanguage;
	}
	public byte[] getMovieimage() {
		return movieimage;
	}
	public void setMovieimage(byte[] movieimage) {
		this.movieimage = movieimage;
	}
}
