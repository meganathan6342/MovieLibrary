<%@page import="DTO.adminDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Changing Password</title>
<link rel="stylesheet" href="CSS_Files/password.css">
<link rel="icon" href="images/user.png">
</head>
<body>
<div id="password">
    <% adminDTO admin = (adminDTO) request.getAttribute("admin"); %>
<form action="changeAdminPW" method="post">
<table>
<tbody>
<tr>
<td><input type="email" name="email" value="<%= admin.getAdminemail()%>" style="display: none;" class="inp"></td>
</tr>
<tr>
<td><input type="password" name="newpass" required placeholder="New Password" class="inp"></td>
</tr>
<tr>
<td><input type="password" name="confirmpass" required placeholder="Confirm Password" class="inp"></td>
</tr>
<tr>
    <td><a href="adminForgetPW.jsp">Forgot Password</a></td>
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