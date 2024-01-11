<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 2px solid black;
	background-color: fuchsia;
}
.button:hover {
	background-color: gray;
}
div {
	position: absolute;
	text-align: center;
	top: 240px;
	left: 530px;
}
</style>
</head>
<body>
 <div>
 <form action="userLogIn" method="post">
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
<td><input type="submit" class="button"> <input type="reset" class="button"></td>
</tr>
</tbody>
</table>
</form>

<% String msg = (String) request.getAttribute("message"); %>
<%if(msg!=null){ %>
<%= msg %>
<%} %>
 
 </div>
</body>
</html>