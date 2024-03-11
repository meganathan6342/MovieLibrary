<%@page import="DTO.adminDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verifying</title>
<link rel="stylesheet" href="CSS_Files/password.css">
<link rel="icon" href="images/user.png">
</head>
<body>
<div id="password">
<% adminDTO admin = (adminDTO) request.getAttribute("admin"); %>
<form action="velifyContactAFPW" method="post">
<table>
<tbody>
<tr>
<td><input type="email" name="email" value="<%= admin.getAdminemail()%>" style="display: none;" class="inp"></td>
</tr>
<tr>
<td>Enter the mobile number that should be connected with <%= admin.getAdminemail() %></td>
</tr>
<tr>
<td><input type="tel" name="contact" required placeholder="Mobile Number" class="inp"></td>
</tr>
<tr>
<td style="text-align: right;"><input type="submit" value="Next" id="button"></td>
</tr>
	<tr>
	<td>
	<p><% String msg = (String) request.getAttribute("message"); %>
	<% if(msg!=null) { %>
	<%= msg %>
	<% } %></p>
	</td>
	</tr>
</tbody>
</table>
</form>
</div>
</body>
</html>