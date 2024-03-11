<%@page import="DTO.adminDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personal</title>
<link rel="icon" href="images/user.png">
<link rel="stylesheet" href="CSS_Files/password.css">
</head>
<body>
<div id="password">
    <% adminDTO admin = (adminDTO) request.getAttribute("admin"); %>
<form action="editAdmin" method="post">
    <table>
    <tbody>
    <tr>
    <td><input type="email" name="adminemail" value="<%= admin.getAdminemail()%>" style="display: none;" class="inp"></td>
    </tr>
    <tr>
    <td><input type="text" name="adminname" value="<%= admin.getAdminname()%>" class="inp"></td>
    </tr>
    <tr>
    <td><input type="tel" name="admincontact" value="<%= admin.getAdmincontact()%>" class="inp"></td>
    </tr>
    <tr>
    <td style="text-align: right;"><input type="submit" value="Sumbit" id="button"></td>
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