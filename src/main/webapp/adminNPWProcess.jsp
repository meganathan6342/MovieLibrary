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
<form action="adminNPWProcess" method="post">
<table>
<tbody>
<tr>
<td><input type="email" name="adminemail" value="<%= admin.getAdminemail() %>" style="display: none;"></td>
</tr>
<tr>
<td><input type="password" name="adminpassword" required placeholder="old password"></td>
</tr>
<tr>
<td><input type="password" name="newpass" required placeholder="new password"></td>
</tr>
<tr>
<td><input type="password" name="confirmpass" required placeholder="confirm password"></td>
</tr>
<tr>
<td><input type="submit" value="confirm"></td>
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