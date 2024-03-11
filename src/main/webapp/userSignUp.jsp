<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="CSS_Files/signup.css">
<link rel="icon" href="images/user.png">
</head>
<body>
<div id="sigup">
 <form action="userSignUp" method="post">
 <table>
 <tbody>
    <tr><td><h2><i>Welcome User</i></h2></td></tr>
 <tr>
 <td><input type="number" name="userid" required class="inp" placeholder="Id"></td>
 </tr>
  <tr>
  <td><input type="text" name="username" required="required" class="inp" placeholder="Name"></td>
  </tr>
   <tr>
   <td><input type="tel" name="usercontact" required="required" class="inp" placeholder="Contact"></td>
   </tr>
    <tr>
    <td><input type="email" name="useremail" required="required" class="inp" placeholder="Email"></td>
    </tr>
     <tr>
     <td><input type="password" name="userpassword" required="required" class="inp" placeholder="Password"></td>
     </tr>
     <tr>
     <td style="text-align: right;"><input type="submit" value="Next" class="button"></td>
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
        <td><h4>or</h4></td>
     </tr>
     <tr><td><a href="userLogin.jsp">login</a></td></tr>
 </tbody>
 </table>
 </form>
</div>
</body>
</html>