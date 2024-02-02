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
<form action="editAdmin" method="post">
<table>
<tbody>
<tr>
<td><input type="email" name="adminemail" value="<%= admin.getAdminemail()%>" style="display: none;"></td>
</tr>
<tr>
<td>Name</td>
</tr>
<tr>
<td><input type="text" name="adminname" value="<%= admin.getAdminname()%>"></td>
</tr>
<tr>
<td>Contact</td>
</tr>
<tr>
<td><input type="tel" name="admincontact" value="<%= admin.getAdmincontact()%>"></td>
</tr>
<tr>
<td><input type="submit"></td>
</tr>
</tbody>
</table>
</form>
</body>
</html>