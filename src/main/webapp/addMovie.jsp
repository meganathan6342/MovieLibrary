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
     background-color: lime;
}
div {
	position: absolute;
	text-align: center;
	top: 120px;
	left: 500px;
}
.button:hover {
	background-color: gray;
}
</style>
</head>
<body>
 <div>
 <h1 style="text-align: center;">Add movies</h1>
 <form action="saveMovie" method="post" enctype="multipart/form-data">
 
 <table>
 <tbody>
 <tr>
 <td><label>Movie ID *</label></td>
 <td><input type="number" name="movieid" required="required" placeholder="e.g:01"></td>
 </tr>
 <tr>
 <td><label>Movie Name *</label></td>
 <td><input type="text" name="moviename" required="required" placeholder="e.g:Vada Chennai"></td>
 </tr>
 <tr>
 <td><label>Movie Rating *</label></td>
 <td><input type="tel" name="movierating" required="required" placeholder="e.g:9.2"></td>
 </tr>
 <tr>
 <td><label>Movie Price *</label></td>
 <td><input type="tel" name="movieprice" required="required" placeholder="e.g:250"></td>
 </tr>
 <tr>
 <td><label>Movie Genre *</label></td>
 <td><input type="text" name="moviegenre" required="required" placeholder="e.g:gangstar drama"></td>
 </tr>
 <tr>
 <td><label>Movie Language *</label></td>
 <td><input type="text" name="movielanguage" required="required" placeholder="e.g:Tamil"></td>
 </tr>
 <tr>
 <td><label>Movie Image *</label></td>
 <td><input type="file" name="movieimage" required="required"></td>
 </tr>
 <tr>
 <td><input type="submit" class="button"><input type="reset" class="button"></td>
 </tr>
 </tbody>
 </table><br>
 
 <!-- <a href="adminHome.jsp">Movie_List</a> -->

 </form>
 </div>
</body>
</html>