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
<form action="velifyContactAFPW" method="post">
<table>
<tbody>
<tr>
<td><input type="email" name="email" value="<%= admin.getAdminemail()%>" style="display: none;"></td>
</tr>
<tr>
<td>Enter the contact that should be connected with <%= admin.getAdminemail() %></td>
</tr>
<tr>
<td><input type="tel" name="contact" required placeholder="phone number"></td>
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