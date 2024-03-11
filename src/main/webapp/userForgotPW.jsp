<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retrieving Account</title>
<link rel="stylesheet" href="CSS_Files/password.css">
<link rel="icon" href="images/user.png">
</head>
<body>
<div id="password">
    <form action="velifyEmailUFPW" method="post">
        <table>
        <tbody>
        <tr>
        <td>Enter the Email</td>
        </tr>
        <tr>
        <td><input type="email" required name="email" class="inp"></td>
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