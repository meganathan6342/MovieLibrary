<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin LogIn</title>
<link rel="stylesheet" href="CSS_Files/adminLogIn.css" type="text/css">
</head>
<body>
 <div>
 <form action="adminLogIn" method="post">
<table>
<tbody>
<h1 style="text-align: left; font-family: sans-serif; font: italic;">Hello Admin</h1>
<tr>
<td colspan="2">
<button class="button"><i class="fa-brands fa-google"></i>  login with Google</button>
</td>
</tr>
<tr>
<td>
<fieldset>
<legend><h5>OR</h5></legend>
</fieldset>
</td>
</tr>
<tr>
<td><input type="email" name="email" required="required" class="input" placeholder="Email"></td>
</tr>
<tr>
<td><input type="password" name="password" required="required" class="input" placeholder="Password"></td>
</tr>
<tr>
<td><a href="adminForgotPW.jsp">forgot password</a></td>
<td>
<input type="submit" value="login" class="button"> 
</td>
</tr>
</tbody>
</table>
</form>
<% String msg = (String) request.getAttribute("message"); %>
<% if(msg!=null){ %>
<%= msg %>
<%} %>
<fieldset>
<legend><h5>OR</h5></legend>
<button class="button"><a href="adminSignUp.jsp">New ?</a></button>
</fieldset>
 </div>
 <script src="https://kit.fontawesome.com/52bd1c8b9d.js" crossorigin="anonymous"></script>
</body>
</html>