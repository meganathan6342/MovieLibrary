<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin SignUp</title>
<link rel="stylesheet" type="text/css" href="CSS_Files/adminSignUp.css">

</head>
<body>
<div>
 <form action="adminServlet" method="post">
 <table>
 <tbody>
 <tr>
 <td><label>ID *</label></td>
 </tr>
 <tr>
 <td><input type="number" name="id" required="required" class="inp"></td>
 </tr>
 <tr>
 <td><label>Name *</label></td>
 </tr>
  <tr>
  <td><input type="text" name="name" required="required" class="inp"></td>
  </tr>
  <tr>
  <td><label>Contact *</label></td>
  </tr>
   <tr>
   <td><input type="tel" name="contact" required="required" class="inp"></td>
   </tr>
   <tr>
   <td><label>Email *</label></td>
   </tr>
    <tr>
    <td><input type="email" name="email" required="required" class="inp"></td>
    </tr>
    <tr>
    <td><label>Password *</label></td>
    </tr>
     <tr>
     <td><input type="password" name="password" required="required" class="inp"></td>
     </tr>
     <tr>
     <td><input type="submit" class="button"></td>
     </tr>
 </tbody>
 </table>
 </form>
 <% String msg = (String) request.getAttribute("message"); %>
 <%if(msg!=null){%>
 <%=msg %>
 <%} %>
</div>
</body>
</html>