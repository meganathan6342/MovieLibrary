<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid black;
	background-color: aqua;
}
</style>
</head>
<body>
 <form action="adminServlet" method="post">
 <center>
 <table>
 <tbody>
 <tr>
 <td><label>ID *</label></td>
 <td><input type="number" name="id" required="required" placeholder="e.g:01"></td>
 </tr>
  <tr>
  <td><label>Name *</label></td>
  <td><input type="text" name="name" required="required" placeholder="e.g:Meganathan"></td>
  </tr>
   <tr>
   <td><label>Contact *</label></td>
   <td><input type="tel" name="contact" required="required" placeholder="e.g:1234567890"></td>
   </tr>
    <tr>
    <td><label>Email *</label></td>
    <td><input type="email" name="email" required="required" placeholder="e.g:abc@gmail.com"></td>
    </tr>
     <tr>
     <td><label>Password *</label></td>
     <td><input type="password" name="password" required="required" placeholder="e.g:AB@ajk72587"></td>
     </tr>
     <tr>
     <td><input type="submit"></td>
     <td><input type="reset"></td>
     </tr>
 </tbody>
 </table>
 </center>
 </form>
 
 <% String msg = (String) request.getAttribute("message"); %>
 <%if(msg!=null){%>
 <%=msg %>
 <%} %>
</body>
</html>