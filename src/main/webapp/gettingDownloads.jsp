<%@page import="DAO.movieDAO"%>
<%@page import="DTO.movieDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Downloads</title>
<link rel="icon" href="images/logo.png">
<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
}
td,th{
    border: 1px solid black;
    padding: 10px;
}
</style>
</head>
<body>
<% List<movieDTO> downloads = (List<movieDTO>) request.getAttribute("downloads"); %>
<% String useremail = (String) request.getAttribute("user"); %>

<table>
<thead>
<tr>
<th>Movie</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<% for(movieDTO d : downloads) { %>
<tr>
<td><%= d.getMoviename() %></td>
<td><a href="deleteDownload?id=<%= d.getMovieid()%>&user=<%= useremail%>">delete</a></td>
</tr>
</tbody>
<% } %>
</table>
<% String msg = (String) request.getAttribute("message"); %>
<% if(downloads == null) { %>
<%= msg %>
<% } %>
</body>
</html>