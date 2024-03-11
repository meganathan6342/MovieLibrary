<%@page import="DTO.userDTO"%>
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
<% userDTO user = (userDTO) request.getAttribute("user"); %>
<form action="velifyContactUFPW" method="post">
<table>
<tbody>
<tr>
<td><input type="email" name="email" value="<%= user.getUseremail()%>" style="display: none;" class="inp"></td>
</tr>
<tr>
<td>Enter the mobile number that should be connected with <%= user.getUseremail() %></td>
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