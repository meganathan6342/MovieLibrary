<%@page import="DTO.userDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Changing Password</title>
<link rel="stylesheet" href="CSS_Files/password.css">
</head>
<body>
<div id="password">
<% userDTO user = (userDTO) request.getAttribute("user"); %>
<form action="userNPWProcess" method="post">
<table>
<tbody>
<tr>
<td><input type="email" name="useremail" value="<%= user.getUseremail() %>" style="display: none;" class="inp"></td>
</tr>
<tr>
<td><input type="password" name="userpassword" required placeholder="old password" class="inp"></td>
</tr>
<tr>
<td><input type="password" name="newpass" required placeholder="new password" class="inp"></td>
</tr>
<tr>
<td><input type="password" name="confirmpass" required placeholder="confirm password" class="inp"></td>
</tr>
<tr>
<td style="text-align: right;"><input type="submit" value="Confirm" id="button"></td>
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