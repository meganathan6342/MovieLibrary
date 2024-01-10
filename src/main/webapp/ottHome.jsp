<%@page import="DTO.movieDTO"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center;">Home</h1>
<% List<movieDTO> m = (List) request.getAttribute("movies"); %>
<% for(movieDTO movie : m){ %>
<% String base64 = new String(Base64.getEncoder().encode(movie.getMovieimage())); %>
<img alt="" src="data:image/jpeg;base64, <%=base64%>" height="500px" width="350px"><br>
<b><i><%= movie.getMoviename() %></i></b><br>
Rating:<%= movie.getMovierating() %><br>
Price:<%= movie.getMovieprice() %><br>
Genre:<%= movie.getMoviegenre() %><br>
Language:<%= movie.getMovielanguage() %><br><br>
<%} %>

</body>
</html>