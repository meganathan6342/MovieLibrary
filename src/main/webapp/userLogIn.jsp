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
	background-color: fuchsia;
}
</style>
</head>
<body>
<form action="userLogIn" method="post">
<center>
<table>
<tbody>
<tr>
<td><label>User Email *</label></td>
<td><input type="email" name="useremail" required="required"></td>
</tr>
<tr>
<td><label>User Password *</label></td>
<td><input type="password" name="userpassword" required="required"></td>
</tr>
<tr>
<td><input type="submit"> <input type="reset"></td>
</tr>
</tbody>
</table>
</center>
</form>

<% String msg = (String) request.getAttribute("message"); %>
<%if(msg!=null){ %>
<%= msg %>
<%} %>

</body>
</html>