<%@page import="DTO.movieDTO"%>
<%@page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Movie</title>
<link rel="icon" href="images/logo.png">
<link rel="stylesheet" href="CSS_Files/movie.css">
</head>
<body>
<div id="movie">
    <section id="left">
        <% movieDTO m = (movieDTO) request.getAttribute("movie"); %>
<form action="editProcess" method="post" enctype="multipart/form-data">
    <table>
    <tbody>
        <tr><td><h2>Edit Details</h2></td></tr>
    <tr>
    <td><input type="number" name="movieid" readonly value="<%= m.getMovieid()%>" class="inp"></td>
    </tr>
    <tr>
    <td><input type="text" name="moviename" value="<%= m.getMoviename()%>" class="inp"></td>
    </tr>
    <tr>
    <td><input type="tel" name="movierating" value="<%= m.getMovierating()%>" class="inp"></td>
    </tr>
    <tr>
    <td><input type="tel" name="movieprice" value="<%= m.getMovieprice()%>" class="inp"></td>
    </tr>
    <tr>
    <td><input type="text" name="moviegenre" value="<%= m.getMoviegenre()%>" class="inp"></td>
    </tr>
    <tr>
    <td><input type="text" name="movielanguage" value="<%= m.getMovielanguage()%>" class="inp"></td>
    </tr>
    <tr>
        <td style="text-align: left; padding-left: 40px;" >Movie Image</td>
    </tr>
    <tr>
    <td><input type="file" name="movieimage" class="inp"></td>
    </tr>
    <tr>
    <td style="text-align: right;"><input type="submit" value="Complate" class="button">
    </tr>
    <tr>
        <td>
        <p style="color: red;"><% String msg = (String) request.getAttribute("message"); %>
 			<% if(msg != null) { %>
 			<%= msg %>
 			<% } %></p>
        </td>
    </tr>
    </tbody>
    </table>
    </form>
    </section>
    <section id="right">
    	<% String base64image = new String(Base64.getEncoder().encode(m.getMovieimage())); %>
        <img alt="image is loading" src="data:image/jpeg;base64 , <%= base64image%>" height="450px" width="350px">
    </section>
</div>
</body>
</html>