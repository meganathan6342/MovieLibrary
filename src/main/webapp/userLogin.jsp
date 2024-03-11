<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
<link rel="stylesheet" href="CSS_Files/login.css">
<link rel="icon" href="images/user.png">
</head>
<body>
 <div id="login">
    <form action="userLogIn" method="post">
        <table>
        <tbody>
        <tr><td><h2><i>Hello User</i></h2></td></tr>
        <tr>
        <td>
        <button class="button"><i class="fa-brands fa-google"></i>  login with Google</button>
        </td>
        </tr>
        <tr>
        <td><h4>or</h4></td>
        </tr>
        <tr>
        <td><input type="email" name="useremail" required="required" placeholder="Email" class="inp"></td>
        </tr>
        <tr>
        <td><input type="password" name="userpassword" required="required" placeholder="Password" class="inp"></td>
        </tr>
        <tr>
        <td style="text-align: left;"><a href="userForgotPW.jsp">forgot password</a></td>
        </tr>
        <tr>
        <td style="text-align: right;"><input type="submit" id="button" value="Next"></td>
        </tr>
        <tr>
        <td>
        <p style="color: red;"><% String msg = (String) request.getAttribute("message"); %>
 			<% if(msg != null) { %>
 			<%= msg %>
 			<% } %></p>
        </td>
    	</tr>
        <tr>
            <td>
                <fieldset>
                    <legend><p>or</p></legend>
                </fieldset>
            </td>
        </tr>
        <tr><td><a href="userSignUp.jsp">New ?</a></td></tr>
        </tbody>
        </table>
        </form>
 </div>
 <script src="https://kit.fontawesome.com/52bd1c8b9d.js" crossorigin="anonymous"></script>
</body>
</html>