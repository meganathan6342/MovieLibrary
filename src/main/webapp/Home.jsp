<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a{
   text-decoration: none;
}
a:hover {
	font-size: x-large;
}
div{
    position: absolute;
    top: 210px;
    left: 500px;
    text-align: center;
}
</style>

</head>
<body>
<div>
<h1 style="text-align: center;">Welcome To Movie Library</h1>
<b><i>
<a href="admin.jsp">Admin</a><br><br><br>
<a href="user.jsp">User</a>
</i></b><br>

<% String msg = (String) request.getAttribute("message"); %>
<%if(msg!=null){ %>
<%=msg %>
<%} %>
</div>
</body>
</html>