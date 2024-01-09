<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1 style="text-align: center;">Welcome To PotStar OTT</h1>
<center><b><i>
<a href="admin.jsp">Admin</a><br><br><br>
<a href="user.jsp">User</a>
</i></b><br>

<% String msg = (String) request.getAttribute("message"); %>
<%if(msg!=null){ %>
<%=msg %>
<%} %>
</center>
</body>
</html>