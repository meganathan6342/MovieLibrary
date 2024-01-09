<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border: 1px solid black;
	background-color: silver;
}
</style>
</head>
<body>
<form action="userSignUp" method="post">
<center>
<table>
<tbody>
<tr>
<td><label>User ID *</label></td>
<td><input type="number" name="userid" required="required" placeholder="e.g:01"></td>
</tr>
<tr>
<td><label>User Name *</label></td>
<td><input type="text" name="username" required="required" placeholder="e.g:Maganathan"></td>
</tr>
<tr>
<td><label>User Contact *</label></td>
<td><input type="tel" name="usercontact" required="required" placeholder="e.g:1234567890"></td>
</tr>
<tr>
<td><label>User Email *</label></td>
<td><input type="email" name="useremail" required="required" placeholder="e.g:abc123@gmail.com"></td>
</tr>
<tr>
<td><label>User Password *</label></td>
<td><input type="password" name="userpassword" required="required" placeholder="e.g:Ajgsy&{742_;s}"></td>
</tr>
<tr>
<td><input type="submit"> <input type="reset"></td>
</tr>
</tbody>
</table>
</center>
</form>
<%String msg = (String) request.getAttribute("message"); %>

<%if(msg!=null){ %>

<%=msg %>
<%} %>


</body>
</html>