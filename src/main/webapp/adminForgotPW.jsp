<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="velifyEmailAFPW" method="post">
<table>
<tbody>
<tr>
<td>Enter the Email</td>
</tr>
<tr>
<td><input type="email" required name="email"></td>
</tr>
<tr>
<td><input type="submit" value="next"></td>
</tr>
</tbody>
</table>
</form>
<% String msg = (String) request.getAttribute("message"); %>
<% if(msg!=null) { %>
<%= msg %>
<% } %>
</body>
</html>