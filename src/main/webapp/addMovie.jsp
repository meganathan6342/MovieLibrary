<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Movie</title>
<link rel="stylesheet" href="CSS_Files/movie.css">
<link rel="icon" href="images/logo.png">
</head>
<body>
 <div id="movie">
 <form action="saveMovie" method="post" enctype="multipart/form-data">
 <table>
 <tbody>
    <tr><td><h2>Add a movie</h2></td></tr>
 <tr>
 <td><input type="number" name="movieid" required="required" placeholder="Movie Id" class="inp"></td>
 </tr>
 <tr>
 <td><input type="text" name="moviename" required="required" placeholder="Movie Name" class="inp"></td>
 </tr>
 <tr>
 <td><input type="tel" name="movierating" required="required" placeholder="Movie Rating" class="inp"></td>
 </tr>
 <tr>
 <td><input type="tel" name="movieprice" required="required" placeholder="Movie Price" class="inp"></td>
 </tr>
 <tr>
 <td><input type="text" name="moviegenre" required="required" placeholder="Movie Genre" class="inp"></td>
 </tr>
 <tr>
 <td><input type="text" name="movielanguage" required="required" placeholder="Movie Language" class="inp"></td>
 </tr>
 <tr><td style="text-align: left;">Movie Image</td></tr>
 <tr>
 <td><input type="file" name="movieimage" required="required"></td>
 </tr>
 <tr>
 <td style="text-align: right;"><input type="submit" value="Complete" class="button"></td>
 </tr>
 <tr>
 <td>
 <p style="color: red;"><% String msg = (String) request.getAttribute("message"); %>
 <% if(msg != null) { %>
 <%= msg %>
 <% } %></p>
 </td>
 </tr>
 </tbody>
 </table>
 </form>
 </div>
</body>
</html>