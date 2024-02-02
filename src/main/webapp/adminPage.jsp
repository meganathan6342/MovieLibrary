<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page import="DTO.movieDTO"%>
<%@page import="DTO.adminDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,th{
    border: 1px solid black;
    border-collapse: collapse;
    text-align: center;
}
td{
     border: 1px solid black;
     height: 300px;
     width: 250px;
}
a{
    text-decoration: none;
}
a:hover {
	font-size: x-large;
}
</style>
</head>
<body>
<h1 style="text-align: center;">Admin Home</h1>

<% List<movieDTO> movies = (List) request.getAttribute("movies"); %>
<% adminDTO admin = (adminDTO) request.getAttribute("admin"); %>
<table>
<thead>
<tr>
<th>Movie ID</th>
<th>Movie Name</th>
<th>Movie Rating</th>
<th>Movie Price</th>
<th>Movie Genre</th>
<th>Movie Language</th>
<th>Movie Image</th>
<th>Delete</th>
<th>Edit</th>
</tr>
</thead>
<tbody>

<%for(movieDTO m : movies) { %>
<tr>
<td><%= m.getMovieid() %></td>
<td><%= m.getMoviename() %></td>
<td><%= m.getMovierating() %></td>
<td><%= m.getMovieprice() %></td>
<td><%= m.getMoviegenre() %></td>
<td><%= m.getMovielanguage() %></td>

<% String base64image = new String(Base64.getEncoder().encode(m.getMovieimage())); %>
<td><img alt="image is loading" src="data:image/jpeg;base64, <%=base64image %>" height="250px" width="150px"></td>
<td><a href="deleteMovie?id=<%= m.getMovieid()%>">delete</a></td>
<td><a href="editMovie?id=<%= m.getMovieid()%>">Edit</a></td>
</tr>

<%} %>
</tbody>
</table>
<a href="addMovie.jsp">Add Movie</a>
<a href="personal?email=<%= admin.getAdminemail()%>">Personal</a>
<a href="adminNewPWord?email=<%= admin.getAdminemail()%>">Change Password</a>
<a href="logOut">Log Out</a>
<% String msg = (String) request.getAttribute("message"); %>
<% if(msg!=null) { %>
<%= msg %>
<% } %>
<br><br>

</body>
</html>