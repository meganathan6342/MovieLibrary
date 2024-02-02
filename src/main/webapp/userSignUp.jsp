<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border: 2px solid black;
	background-color: silver;
}
.button:hover {
	background-color: gray;
}
div {
	position: absolute;
	text-align: center;
	top: 210px;
	left: 520px;
}
</style>
</head>
<body>

<div>
<form action="userSignUp" method="post">

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
<td><input type="submit" class="button"> <input type="reset" class="button"></td>
</tr>
</tbody>
</table>
</form>
<%String msg = (String) request.getAttribute("message"); %>

<%if(msg!=null){ %>

<%=msg %>
<%} %>

</div>

</body>
</html>