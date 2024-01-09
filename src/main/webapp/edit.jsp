<%@page import="DTO.movieDTO"%>
<%@page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border: 1px solid black;
	background-color: green;
}

</style>
</head>
<body>
<% movieDTO m = (movieDTO) request.getAttribute("movie"); %>
<form action="editProcess" method="post" enctype="multipart/form-data">
<center>
<table>
<tbody>
<tr>
<td><label>Movie ID</label></td>
<td><input type="number" name="movieid" readonly value="<%= m.getMovieid()%>"></td>
</tr>
<tr>
<td><label>Movie Name</label></td>
<td><input type="text" name="moviename" value="<%= m.getMoviename()%>"></td>
</tr>
<tr>
<td><label>Movie Rating</label></td>
<td><input type="tel" name="movierating" value="<%= m.getMovierating()%>"></td>
</tr>
<tr>
<td><label>Movie Price</label></td>
<td><input type="tel" name="movieprice" value="<%= m.getMovieprice()%>"></td>
</tr>
<tr>
<td><label>Movie Genre</label></td>
<td><input type="text" name="moviegenre" value="<%= m.getMoviegenre()%>"></td>
</tr>
<tr>
<td><label>Movie Language</label></td>
<td><input type="text" name="movielanguage" value="<%= m.getMovielanguage()%>"></td>
</tr>
<tr>
<td><label>Movie Image</label></td>
<td><input type="file" name="movieimage"></td>
</tr>
<tr>
<td><input type="submit"> <input type="reset"></td>
</tr>
</tbody>
</table>
</center>
</form>
<% String base64image = new String(Base64.getEncoder().encode(m.getMovieimage())); %>
<center><img alt="image is loading" src="data:image/jpeg;base64 , <%= base64image%>" height="250px" width="150px"></center>
</body>
</html>