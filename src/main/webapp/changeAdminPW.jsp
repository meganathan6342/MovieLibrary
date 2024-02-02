<%@page import="DTO.adminDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% adminDTO admin = (adminDTO) request.getAttribute("admin"); %>

<form action="changeAdminPW" method="post">
<table>
<tbody>
<tr>
<td><input type="email" name="email" value="<%= admin.getAdminemail()%>" style="display: none;"></td>
</tr>
<tr>
<td><input type="password" name="newpass" required placeholder="New Password"></td>
</tr>
<tr>
<td><input type="password" name="confirmpass" required placeholder="Confirm Password"></td>
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