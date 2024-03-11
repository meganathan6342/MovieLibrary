<%@page import="DTO.userDTO"%>
<%@page import="DTO.movieDTO"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="icon" href="images/logo.png">
<style>
div{
    position: absolute;
}
img{
    display: inline;
    
}
a{
    text-decoration: none;
    color: green;
}
</style>
</head>
<body>
<h1 style="text-align: center;">Home</h1>
<div>
<% List<movieDTO> m = (List) request.getAttribute("movies"); %>
<% String useremail = (String) request.getAttribute("user"); %>
<%-- <% List<downloadsDTO> d = (List) request.getAttribute("downloads"); %> --%>
<% for(movieDTO movie : m){ %>
<% String base64 = new String(Base64.getEncoder().encode(movie.getMovieimage())); %>
<img alt="image is loading" src="data:image/jpeg;base64, <%=base64%>" height="500px" width="350px"><br>
<b><i><%= movie.getMoviename() %></i></b><br>
Rating:<%= movie.getMovierating() %><br>
Price:<%= movie.getMovieprice() %><br>
Genre:<%= movie.getMoviegenre() %><br>
Language:<%= movie.getMovielanguage() %><br><br>


<a href="downloads?id=<%= movie.getMovieid() %>&user=<%= useremail %>">Save</a> <br><br>

<br>
<a href="userPersonal?email=<%= useremail %>">personal</a>
<a href="userNewPWord?email=<%= useremail%>">Change Password</a>
<a href="userLogOut">Log Out</a>
<%} %>
<a href="gettingDownloads?email=<%= useremail%>">downloads</a>
<% String msg = (String) request.getAttribute("message"); %>
<% if(msg!=null) { %>
<%= msg %>
<% } %>
</div>
<div>
</div>
</body>
</html>